/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.CarroDao;
import Entidade.Carros;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Eder
 */
@ManagedBean
public class CarrosMB {
    private Carros carro;
    private List<Carros> lista;

    public CarrosMB(Carros carro, List<Carros> lista) {
        this.carro = carro;
        this.lista = lista;
    }

    public CarrosMB() {
    }

    public Carros getCarro() {
        return carro;
    }

    public void setCarro(Carros carro) {
        this.carro = carro;
    }

    public List<Carros> getLista() {
        return lista;
    }

    public void setLista(List<Carros> lista) {
        this.lista = lista;
    }
    
    public void salvar(Carros carro){
        CarroDao dao = new CarroDao();
        dao.salvar(carro);
        lista = dao.listar();
    }
    
    public void deletar(int id){
        CarroDao dao = new CarroDao();
        dao.deletar(id);
        lista = dao.listar();
    }
    
    @PostConstruct
    public void inicializar(){
        CarroDao dao = new CarroDao();
        lista = dao.listar();
        
        carro = new Carros();
    }
}
