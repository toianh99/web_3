package controller.DAO.Impl;



import controller.DAO.IUser;
import controller.Mapper.Impl.UserMapper;
import model.User;



public class UserDAOImpl extends BaseDAOImpl<User> implements IUser {
    @Override
    public User Login(User user) {
        String sql ="SELECT * FROM `user` WHERE `Username` = ? AND `Password` =?";
        return query(sql, new UserMapper(),user.getUsername(),user.getPassword()).get(0);
    }

    @Override
    public User findOne(int id) {
        String sql ="SELECT * FROM `user` WHERE `ID`=?";
        return query(sql,new UserMapper(),id).get(0);
    }

    @Override
    public int saveUser(User user) {
        String sql = "INSERT INTO `user`(`Username` ,`Password`) VALUES(?,?)";
        return insert(sql,user.getUsername(),user.getPassword());
    }

    @Override
    public void updateUser(User user) {
        String sql ="UPDATE `user` SET `Password` =? WHERE `ID`=?";
        update(sql,user.getPassword(),user.getIdUser());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM `user` WHERE `ID`= ? ";
        update(sql, id);
    }

    @Override
    public int getCountUser() {
        String sql ="SELECT COUNT(*) FROM `user`";
        return count(sql);
    }

    @Override
    public void deleteUSerRole(int id) {
        String sql = "DELETE FROM `user_role` WHERE `UserID`=?";
        update(sql,id);
    }


//    public User findByUsernamePassword(String usernname, String password) {
//        StringBuilder sql = new StringBuilder("select ct.*, r.*,ac.*,p.* from user_roles as ur");
//        sql.append(" inner join users as u on ur.UseridUser = u.idUser");
//        sql.append(" inner join roles as r on r.idRole = ur.RoleidRole");
//        sql.append(" inner join account as ac on u.idAccount=ac.idAccount");
//        sql.append(" inner join contact as ct on ct.UseridUser=u.idUser");
//        sql.append(" inner join roles_permission as rp on  rp.RoleidRole = r.idRole");
//        sql.append(" inner join Permission as p on p.idPermission = rp.PermissionidPermission");
//        sql.append(" where ac.username= ? AND ac.password= ?");
//
//        System.out.println(sql.toString());
//        Map<String, List<String>> mapConfig = new HashMap<String, List<String>>();
//        HashSet<String> roles = new HashSet<>();
//        HashSet<String> permissions = new HashSet<>();
//        List<User> users = query(sql.toString(),new UserMapper(),usernname,password);
//        if (!users.isEmpty()) {
//            for (User u : users
//            ) {
//                roles.addAll(u.getRoles());
//                permissions.addAll(u.getPermissions());
//            }
//            users.get(0).setRoles(roles);
//            users.get(0).setPermissions(permissions);
//            return users.get(0);
//        }
//        return null;
//    }

//    @Override
//    public List<User> getListUser(int pagesize, int pagenum, SortImpl sort) {
//        StringBuilder sql = new StringBuilder("select ac.*,ct.*,ad.* from users as u");
//        sql.append(" inner join contact as ct on ct.UseridUser = u.idUser");
//                sql.append(" inner join address as ad on ad.UseridUser = u.idUser");
//                sql.append(" inner join account as ac on ac.idUser = u.idUser");
//
//        if(!sort.getSortName().isEmpty()&&!sort.getSortBy().isEmpty()){
//            sql.append(" order by "+sort.getSortName()+" "+sort.getSortBy());
//        }
//            sql.append(" limit "+pagenum+","+pagesize);
//        List<User> users = query(sql.toString(), new ListUserMapperImpl());
//        System.out.println(sql.toString());
//        return users.isEmpty() ? null : users;
//    }

//    @Override
//    public User findOne(int id) {
//        String sql = "SELECT * FROM users WHERE idUser = ?";
//        List<User> news = query(sql, new ListUserMapperImpl(), id);
//        return news.isEmpty() ? null : news.get(0);
//    }
//    @Override
//    public Long save(User user) {
//        String sqlcontact="INSERT INTO contact( firstName,lastName,email,phone,UseridUser )" +
//                " VALUES( ? , ? , ? , ? , ? )";
//        Long idContact = insert(sqlcontact, user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhonenumber(),user.getIdUser());
//        String sqlaccount="INSERT INTO account( username , password , idUser )" +
//                " VALUES( ? , ? )";
//        Long idAccount = insert(sqlaccount, user.getUsername(), user.getPassword() ,user.getIdUser());
//        String sqladdress="INSERT INTO address( homeNumber, street, dictrict, UseridUser)" +
//                " VALUES( ?, ? , ? , ? )";
//        Long address = insert(sqladdress,user.getHomeNumber(),user.getStreet(),user.getDictrict(),user.getIdUser());
//        return address;
//    }
//
//    @Override
//    public void update(User user) {
//        String sql ="UPDATE web.address ad\n" +
//                "    INNER JOIN web.users u\n" +
//                "    ON ad.UseridUser = u.idUser\n" +
//                "    INNER JOIN web.contact ct\n" +
//                "    ON ct.UseridUser =u.idUser\n"+
//                "SET ad.street = ?, ad.dictrict = ?,ad.homeNumber = ?,ct.firstName =? ,ct.lastName=?,ct.email =?,ct.phone =?\n" +
//                "where u.idUser = ?";
//        update(sql, user.getStreet(), user.getDictrict(), user.getHomeNumber(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhonenumber());
//
//    }
//
//    @Override
//    public void delete(int id) {
//        String sql = "DELETE FROM users WHERE idUser = ?";
//        update(sql, id);
//    }
//
//    @Override
//    public int getCountUser() {
//        String sql = "select count(*) from users ";
//        return count(sql);
//    }

}
