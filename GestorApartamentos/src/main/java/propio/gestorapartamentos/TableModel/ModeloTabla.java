package propio.gestorapartamentos.TableModel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import propio.gestorapartamentos.DTO.Apartamento;

/**
 *
 * @author anton
 */
public class ModeloTabla extends AbstractTableModel {

    List<Apartamento> apartamentos;
    String[] columnas = {"Id", "nom", "descripcio", "num_persones", "adresa", "id_municipi", "id_propietari", "destacat", "preu_per_nit"};

    public ModeloTabla(List<Apartamento> apartamentos) {
        this.apartamentos = apartamentos;
    }

    
    
    
    @Override
    public int getRowCount() {

        return apartamentos.size();

    }

    @Override
    public int getColumnCount() {

        return columnas.length;

    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        switch (columnIndex) {
            case 0 -> {
                return apartamentos.get(rowIndex).getId();
            }

            case 1 -> {
                return apartamentos.get(rowIndex).getNom();
            }
            case 2 -> {
                return apartamentos.get(rowIndex).getDescripcio();
            }
            case 3 -> {
                return apartamentos.get(rowIndex).getNum_persones();
            }
            case 4 -> {
                return apartamentos.get(rowIndex).getAdresa();
            }
            case 5 -> {
                return apartamentos.get(rowIndex).getId_municipi();
            }
            case 6 -> {
                return apartamentos.get(rowIndex).getId_propietari();
            }
            case 7 -> {
                return apartamentos.get(rowIndex).getDestacat();
            }
            case 8 -> {
                return apartamentos.get(rowIndex).getPreu_per_nit();
            }
        }
        return null;
    }
    
    @Override
    public String getColumnName(int columna) {
        return columnas[columna];
    }
}
