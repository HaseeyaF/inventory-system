/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pos.pro;

/**
 *
 * @author wow
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */




import static groovy.inspect.Inspector.print;
import java.awt.Container;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.*;
import static jdk.nashorn.internal.objects.Global.print;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.print;
//import static sun.misc.Version.print;



public class ReportView extends JFrame
{
    public ReportView(String fileName)
    {
        this(fileName, null);
    }
   
    
    
    public ReportView(String fileName, HashMap para)
    {
        super("POS System (Report Viewer)");

        db dcon = new db();
        Connection con = dcon.mycon();
                
    

        try
        {
            InputStream file = getClass().getResourceAsStream(fileName);
            //JasperDesign jasperDesign = JRXmLoader.load(file);
            //JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
            JRViewer viewer = new JRViewer(print);
            Container c = getContentPane();
            c.add(viewer);            
        } 
        catch (JRException jRException)
        {
            System.out.println(jRException);
        }
        setBounds(2, 2, 1200, 700);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
