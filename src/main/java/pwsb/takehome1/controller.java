/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwsb.takehome1;


import java.io.IOException;
import java.sql.Blob;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Controller
public class controller {    
    @RequestMapping("/login")
    public String getLogin(@RequestParam (value="inputnama") String nama,
                           @ RequestParam (value="inputtgl") String date,
                           @ RequestParam (value="inputfoto") MultipartFile photo,
                           Model model)
        throws IOException{
        byte[] img = photo.getBytes();
        String base64Image = Base64.encodeBase64String(img);
        String imglink ="data:image/png;base64,".concat(base64Image);
        model.addAttribute("kirimanA", nama);
        model.addAttribute("kirimanB", date);
        model.addAttribute("kirimanC", imglink);
        return "tampilan";
    }
}