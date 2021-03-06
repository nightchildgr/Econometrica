/*
 * Τμήμα ΗΛΕ 43
 * @author ΒΑΣΙΛΗΣ ΤΣΑΠΑΡΙΚΟΣ - 114307
 * @author ΑΙΚΑΤΕΡΙΝΗ ΚΟΛΕΒΕΝΤΗ - 126971
 * @author ΑΡΙΣΤΕΙΔΗΣ ΦΑΣΟΥΛΑΣ - 100318
 */
package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bill
 */
@Entity
@Table(name = "CURRENT_OIL_DATA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CurrentOilData.findAll", query = "SELECT c FROM CurrentOilData c")
    , @NamedQuery(name = "CurrentOilData.findById", query = "SELECT c FROM CurrentOilData c WHERE c.id = :id")
    , @NamedQuery(name = "CurrentOilData.findByDataYear", query = "SELECT c FROM CurrentOilData c WHERE c.dataYear = :dataYear")
    , @NamedQuery(name = "CurrentOilData.findByValue", query = "SELECT c FROM CurrentOilData c WHERE c.value = :value")
    //One line added to the auto generated code
    , @NamedQuery(name = "CurrentOil.deleteAll", query = "DELETE  FROM CurrentOilData ")})
public class CurrentOilData implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATA_YEAR")
    private String dataYear;
    @Basic(optional = false)
    @Column(name = "VALUE")
    private String value;

    public CurrentOilData() {
    }

    public CurrentOilData(Integer id) {
        this.id = id;
    }

    public CurrentOilData(Integer id, String dataYear, String value) {
        this.id = id;
        this.dataYear = dataYear;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getDataYear() {
        return dataYear;
    }

    public void setDataYear(String dataYear) {
        String oldDataYear = this.dataYear;
        this.dataYear = dataYear;
        changeSupport.firePropertyChange("dataYear", oldDataYear, dataYear);
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        String oldValue = this.value;
        this.value = value;
        changeSupport.firePropertyChange("value", oldValue, value);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CurrentOilData)) {
            return false;
        }
        CurrentOilData other = (CurrentOilData) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.CurrentOilData[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
