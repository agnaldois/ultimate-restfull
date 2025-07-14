package br.ultimate_restfull.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String details) { }
