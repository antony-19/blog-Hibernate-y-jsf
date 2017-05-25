/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import sys.model.Post;

/**
 *
 * @author Toño
 */
public interface postDao {
    
    public List<Post> mostrarPost();
    
    public void nuevoPost(Post post);
    public void modificarPost(Post post);
    public void eliminarPost(Post post);

}
