package controller.DAO;

import model.Publisher;

public interface Ipublisher extends IBaseDAO<Publisher> {
    int savePublisher (Publisher publisher);
    void updatePublisher (Publisher publisher);
    void deletePublisher (int id);
    Publisher getPublisherById(int id);
}
