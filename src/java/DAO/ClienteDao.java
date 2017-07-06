/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Clientes;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class ClienteDao {
    public void salvar(Clientes cliente){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        sessao.persist(cliente);
        sessao.getTransaction().commit();
        sessao.close();
    }
    
    public List<Clientes> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Clientes> lista = sessao.getNamedQuery("Clientes.findAll").list();
        sessao.close();
        
        return lista;
    }
    
    public void deletar(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.delete(sessao.get(Clientes.class, id));

        sessao.getTransaction().commit();
        sessao.close();
    }
}
