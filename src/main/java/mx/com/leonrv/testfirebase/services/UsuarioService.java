package mx.com.leonrv.testfirebase.services;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import mx.com.leonrv.testfirebase.domain.Usuario;

@Service
public class UsuarioService implements IUsuarioService{

    /*
     * Coleccion = users
     * Documento = nombreDelUsuario
     * Cada documento contiene 
     *          -id
     *          -username
     *          -password
     * 
     * colleccion -> documento
     *                      -> propiedad
     * users -> leon
     *              ->id: 4
     *              ->username: leon
     *              ->password: leon12345
     */

    @Override
    public Usuario getUsuario(String username) {

        Firestore dbFirestore = FirestoreClient.getFirestore();

        //Busca el documento con el nombre del usuario
        DocumentReference documentReference = dbFirestore.collection("users").document(username);

        //Regresa la referencia del documento
        ApiFuture<DocumentSnapshot> future = documentReference.get();

        DocumentSnapshot document = null;
        try {
            //obtiene el documento
            document = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        Usuario usuario = null;


        //si se encuentra el registro
        if(document.exists()) {
            //convierte a un  objeto tipo Usuario.class
            usuario = document.toObject(Usuario.class);
            return usuario;
        }else {
            return null;
        }
    }

    @Override
    public String saveUsuario(Usuario usuario) {
        Firestore dbFirestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection("users").document(usuario.getUsername()).set(usuario);
        try {
            return collectionsApiFuture.get().getUpdateTime().toString();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public String updateUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public String deleteUser(String username) {
        return null;
    }
    
}
