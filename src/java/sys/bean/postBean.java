/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.bean;


import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import sys.dao.postDao;
import sys.dao.postDaoImp;
import sys.model.Post;

/**
 *
 * @author Toño
 */
@ManagedBean
@ViewScoped
public class postBean {
    
    private List<Post> listar;
    private Post post;
    /**
     * Creates a new instance of postBean
     */
    public postBean() {
        post = new Post();
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public List<Post> getListar() {
        postDao postdao= new postDaoImp();
        listar = postdao.mostrarPost();      
        return listar;
    }
    
    public void prepararnuevoPost(ActionEvent actionEventen){
         post = new Post();
    }
    
    public void nuevoPost(){
        postDao  postdao = new postDaoImp();
        postdao.nuevoPost(post);
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El post se guardo correctamente "));
    }
    
    public void modificarPost(){
        postDao  postdao = new postDaoImp();
        postdao.modificarPost(post);
        post = new Post();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El post se modifico correctamente "));
    }
       public void eliminarPost(){
        postDao  postdao = new postDaoImp();
        postdao.eliminarPost(post);
        post = new Post();
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Correcto","El post se elimino correctamente "));
    }    
    public void cancelar(){
        post = new Post();
    }
}
