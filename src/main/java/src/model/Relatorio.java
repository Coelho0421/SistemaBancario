package src.model;

import java.time.LocalDateTime;

/**
 *
 * @author felip
 */
public class Relatorio {
    
    private Integer id;                //EXTRATO, RESUMO, SALDOS, etc.
    private LocalDateTime dataInicio;
    private LocalDateTime dataFim;
    private String criterios;
    private LocalDateTime geradoEm;
    private String formato;           //PDF, CVS

    public Relatorio(){
    }
    
    public Relatorio(Integer id, LocalDateTime dataInicio, LocalDateTime dataFim, String criterios, LocalDateTime geradoEm, String formato) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.criterios = criterios;
        this.geradoEm = geradoEm;
        this.formato = formato;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public LocalDateTime getDataFim() {
        return dataFim;
    }

    public String getCriterios() {
        return criterios;
    }

    public LocalDateTime getGeradoEm() {
        return geradoEm;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
    
    public Relatorio gerar(){
        Relatorio relatorio = new Relatorio();
        return relatorio;
    }    
    public boolean validarFiltros(){
        return true;
    }
    
    public void exportarCVS(String path){
        
    }
    
    public void exportarPDF(String path){
        
    }
}
