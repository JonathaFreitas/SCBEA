/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uig;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;
import modelos.classes.Editora;

/**
 *
 * @author jsfr
 */
public class ComboboxArray extends AbstractListModel implements ComboBoxModel {

    private List<Editora> lista;
    private Editora editoraSelecionada;

    public ComboboxArray() {
        this.lista = new ArrayList<>();
    }

    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        return lista.get(index);
    }

    @Override
    public void setSelectedItem(Object o) {
        if (this.editoraSelecionada instanceof Editora) {
            this.editoraSelecionada = (Editora) o;
            fireContentsChanged(this.lista, 0, lista.size());
        }
    }

    @Override
    public Object getSelectedItem() {
        return this.editoraSelecionada;
    }
    
    public void addEditora(Editora objeto){
        this.lista.add(objeto);
    }
    
    public void reset(){
        this.lista.clear();
    }

}
