
package hconfort_system.modelo;

import hconfort_system.*;


public class Hospede {
    
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String endereço;
    private String telefone;
    private String horario;
    private String login;
    private String senha;

  
    public String getNome() {
        return nome;
    }

   
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    
    public String getRg() {
        return rg;
    }

    /**
     * @param rg the rg to set
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * @return the endereço
     */
    public String getEndereço() {
        return endereço;
    }

    /**
     * @param endereço the endereço to set
     */
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }
    
    public String getTelefone() {
        return telefone;
    }

   
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
     public String getHorario() {
        return horario;
    }

   
    public void setHorario(String horario) {
        this.horario = horario;
    }
    
     public String getLogin() {
        return login;
    }

   
    public void setLogin(String login) {
        this.login = login;
    }
    
     public String getSenha() {
        return senha;
    }

   
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
