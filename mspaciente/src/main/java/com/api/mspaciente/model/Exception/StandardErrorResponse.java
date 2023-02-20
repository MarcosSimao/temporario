package com.api.mspaciente.model.Exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardErrorResponse implements Serializable {


    private LocalDateTime timeStamp;
    private Integer status;
    private String mensagem;
    private String path;


    public StandardErrorResponse(LocalDateTime timeStamp, Integer status, String mensagem, String path) {
        this.timeStamp = timeStamp;
        this.status = status;
        this.mensagem = mensagem;
        this.path = path;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
