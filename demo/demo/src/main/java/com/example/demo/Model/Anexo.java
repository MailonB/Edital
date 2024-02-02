package com.example.demo.Model;

import jakarta.persistence.*;

@Entity
public class Anexo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int codEdital;

    public Anexo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Anexo(String nome, String link, int codEdital) {
            this.nome = nome;
            this.link = link;
            this.codEdital = codEdital;

        }

        public int getCodEdital() {
            return codEdital;
        }

        public void setCodEdital(int codEdital) {
            this.codEdital = codEdital;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getLink() {
            String texto = "https://wbc.pmf.sc.gov.br/portal/Download.aspx" + link;
            return texto;
        }

        public void setLink(String link) {
            this.link = link;
        }

        @Override
        public String toString() {
            return "Anexos{" +
                    "nome='" + nome + '\'' +
                    ", link='" + link + '\'' +
                    ", codEdital=" + codEdital +
                    '}';
        }
}
