package com.example.demo.api.comment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// to instruuje Spring MCV, ze ten wyjatek ma "zmappowac" na odpowiedz HTTP o kodzie 404 (czyli NOT_FOUND) i wiadomosci "Comment not found"
// domyslnie Spring MCV kazdy wyjatek mappuje na HTTP 500 (Internal server error), a w wiadomosc wrzuca stacktrace wyjatku
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Comment not found")
public class CommentNotFoundException extends RuntimeException {
}
