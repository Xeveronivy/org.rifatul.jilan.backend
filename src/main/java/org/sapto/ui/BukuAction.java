    package org.sapto.ui;

    import org.sapto.model.Publisher;
    import org.sapto.services.BukuService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.ModelMap;
    import org.springframework.web.bind.annotation.*;
    import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

    import javax.servlet.http.HttpServletRequest;
    import java.sql.SQLException;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    @Controller
    public class BukuAction {

        @Autowired
        BukuService bukuService;

        @GetMapping("/beranda/{id}")
        public String beranda(ModelMap kirimData, HttpServletRequest req,
                              @RequestParam(value = "rp") Integer nilai,
                              @PathVariable/*(value = "id")*/ Integer id) {
            String paraNama = req.getParameter("nama");
            String paraDua = req.getParameter("dua");
            kirimData.addAttribute("data", "ini data yang dikirim" + paraNama + " " + paraDua +
                    " Rp = " + nilai + " id ===>" + id);
            try {
                kirimData.addAttribute("buku", bukuService.getDataBuku(id));
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "home";

        }

        @GetMapping("/bukupilihan")
        public String bukuAll(ModelMap kirimData) {
            try {
                kirimData.addAttribute("buku", bukuService.getDataBukuAll());
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return "bukubanyak";

        }

        @GetMapping("/api/publisher")
        public ResponseEntity<List<Publisher>> publisherAll() {
            try {
                return ResponseEntity.ok(bukuService.getPublisherAll());
            } catch (SQLException e) {
                e.printStackTrace();
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }

            }

            @GetMapping("/api/editelem1/{id}")
            public ResponseEntity<Publisher> PublisherAll(@PathVariable Integer id) {
                return ResponseEntity.ok(bukuService.getPublisher(id));
            }

        @PostMapping("/api/simpanPublisher")
        public ResponseEntity  <Map<String,Object>> savePublisher(@RequestBody Publisher publisher) {
            bukuService.simpanPublisher(publisher);
            Map<String, Object> map = new HashMap<>();
            map.put("kode", 200);
            map.put("simpan", "data berhasil disimpan");
            bukuService.simpanPublisher(publisher);
            return ResponseEntity.ok(map);
        }
        }
