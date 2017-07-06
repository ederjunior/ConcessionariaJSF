/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Carros;
import Entidade.Clientes;
import Util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Eder
 */
public class CarroDao {
    public void salvar(Carros carro){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();
        sessao.persist(carro);
        sessao.getTransaction().commit();
        sessao.close();
    }
    
    public List<Carros> listar(){
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        List<Carros> lista = sessao.getNamedQuery("Carros.findAll").list();
        sessao.close();
        
        return lista;
    }
    
    public void deletar(int id) {
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        sessao.beginTransaction();

        sessao.delete(sessao.get(Carros.class, id));

        sessao.getTransaction().commit();
        sessao.close();
    }
}
