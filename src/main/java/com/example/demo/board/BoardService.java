package com.example.demo.board;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import com.example.demo.user.UserRepository;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public BoardDto.RegRes register(BoardDto.RegReq dto) {
        Board entity = boardRepository.save(dto.toEntity(getCurrentUser()));

        return BoardDto.RegRes.from(entity);
    }

    public List<BoardDto.ListRes> list() {
        List<Board> boardList = boardRepository.findAll();
        return boardList.stream().map(BoardDto.ListRes::from).toList();
    }

    public BoardDto.ReadRes read(Long idx) {
        Board board = boardRepository.findById(idx).orElseThrow();
        return BoardDto.ReadRes.from(board);
    }

    public BoardDto.RegRes update(Long idx, BoardDto.RegReq dto) {
        Board board = boardRepository.findById(idx).orElseThrow();
        board.update(dto);

        boardRepository.save(board);

        return BoardDto.RegRes.from(board);
    }

    public void delete(Long idx) {
        boardRepository.deleteById(idx);
    }

    private User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication.getName() == null) {
            throw new IllegalArgumentException("인증되지 않은 사용자입니다.");
        }

        String email = authentication.getName();
        return userRepository.findByEmail(email).orElseThrow(
                () -> new IllegalArgumentException("사용자를 찾을 수 없습니다.")
        );
    }
}
