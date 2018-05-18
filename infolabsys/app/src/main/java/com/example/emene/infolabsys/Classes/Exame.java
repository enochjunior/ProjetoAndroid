package com.example.emene.infolabsys.Classes;

/**
 * Created by emene on 03/04/2018.
 */

public class Exame {

    private int id;
    private String descricao;
    private int status;
    private String codigo;
    private boolean sel;

    public void setSel(boolean sel) {
        this.sel = sel;
    }

    public boolean isSel() {
        return sel;
    }

    public Exame(int id, String nome, int status, String codigo, boolean sel) {
        this.id = id;
        this.descricao = nome;
        this.status = status;
        this.codigo = codigo;
        this.sel = sel;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return codigo;
    }
}
