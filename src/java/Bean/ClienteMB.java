/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import DAO.ClienteDao;
import Entidade.Clientes;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Eder
 */
@ManagedBean
public class ClienteMB {
    private Clientes cliente;
    private List<Clientes> lista;

    public ClienteMB(Clientes cliente, List<Clientes> lista) {
        this.cliente = cliente;
        this.lista = lista;
    }

    public ClienteMB() {
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public List<Clientes> getLista() {
        return lista;
    }

    public void setLista(List<Clientes> lista) {
        this.lista = lista;
    }
    
    public void salvar(Clientes cli){
        ClienteDao dao = new ClienteDao();
        dao.salvar(cli);
        lista = dao.listar();
    }
    
    public void deletar(int id){
        ClienteDao dao = new ClienteDao();
        dao.deletar(id);
        lista = dao.listar();
    }
    
    @PostConstruct
    public void inicializar(){
        ClienteDao dao = new ClienteDao();
        lista = dao.listar();
        
        cliente = new Clientes();
    }
}
