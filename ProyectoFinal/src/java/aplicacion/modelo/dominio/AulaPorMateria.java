/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacion.modelo.dominio;

/**
 *
 * @author natan
 */
public class AulaPorMateria {
    private int codigo;
    private String periodo;
    private String comentario;
    private String dia;
    private String horarioDesde;
    private String horarioHasta;
    private boolean estado;
    private DocentePorMateria docentePorMateria;
    private Aula aula;
    private String franjaHoraria;

    public AulaPorMateria() {
    }
    
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHorarioDesde() {
        return horarioDesde;
    }

    public void setHorarioDesde(String horarioDesde) {
        this.horarioDesde = horarioDesde;
    }

    public String getHorarioHasta() {
        return horarioHasta;
    }

    public void setHorarioHasta(String horarioHasta) {
        this.horarioHasta = horarioHasta;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public DocentePorMateria getDocentePorMateria() {
        return docentePorMateria;
    }

    public void setDocentePorMateria(DocentePorMateria docentePorMateria) {
        this.docentePorMateria = docentePorMateria;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public String getFranjaHoraria() {
        return franjaHoraria;
    }

    public void setFranjaHoraria(String franjaHoraria) {
        this.franjaHoraria = franjaHoraria;
    }
    
    
}
