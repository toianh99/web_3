package controller.SERVICE.Impl;

import controller.DAO.Impl.PublisherDAOImpl;
import controller.SERVICE.IPublisherService;
import model.Publisher;

import java.util.List;

public class PublisherService implements IPublisherService {
    private PublisherDAOImpl publisherDAO= new PublisherDAOImpl();
    @Override
    public int savePublisher(Publisher publisher) {
       return publisherDAO.savePublisher(publisher);
    }

    @Override
    public void updatePublisher(Publisher publisher) {
        publisherDAO.updatePublisher(publisher);
    }

    @Override
    public void deletePublisher(int id) {
        publisherDAO.deletePublisher(id);
    }

    @Override
    public Publisher getPublisherById(int id) {
        return publisherDAO.getPublisherById(id);
    }

    @Override
    public List<Publisher> getPublisher(int pagenum, int pagesize) {
        return publisherDAO.getPublisher(pagenum,pagesize);
    }
}
