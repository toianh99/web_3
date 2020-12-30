package controller.API.Amin;

import com.fasterxml.jackson.databind.ObjectMapper;
import controller.SERVICE.Impl.PublisherService;
import controller.SHARE.HttpUtil;
import model.Publisher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PublisherAPI",urlPatterns = {"/api-v1-publisher"})
public class PublisherAPI extends HttpServlet {
    private PublisherService publisherService = new PublisherService();
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        String id = req.getParameter("id");
        if(id!=null){
            Publisher publisher = publisherService.getPublisherById(Integer.parseInt(id));
            mapper.writeValue(resp.getOutputStream(),publisher);
        }
        else{
            List<Publisher> publishers = publisherService.getPublisher(0,100);
            mapper.writeValue(resp.getOutputStream(),publishers);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Publisher publisher = HttpUtil.of(req.getReader()).toModel(Publisher.class);
        publisherService.savePublisher(publisher);
        mapper.writeValue(resp.getOutputStream(),publisher);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Publisher publisher = HttpUtil.of(req.getReader()).toModel(Publisher.class);
        publisherService.updatePublisher(publisher);
        mapper.writeValue(resp.getOutputStream(),publisher);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        Publisher publisher = HttpUtil.of(req.getReader()).toModel(Publisher.class);
        publisherService.deletePublisher(publisher.getId());
        mapper.writeValue(resp.getOutputStream(),publisher);
    }
}
