package com.gannyee.controller;

import com.gannyee.model.UserEntity;
import com.gannyee.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by gannyee on 2017/5/7.
 */

//@Controller ����ע��ķ�ʽ��������ȷ�ض������Ϊ���������Controller��
@Controller
public class MainController {

    //�Զ�װ�����ݿ�ӿڣ�����Ҫ��дԭʼ��Connection���������ݿ�
    @Autowired
    UserRepository userRepository;

    //���ڶ���һ�������ӳ�䣬valueΪ�����url��ֵΪ'/'˵�� ������Ϊ��ҳ����method����ָ���������ͣ�һ��Ϊget �� post
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        //���������󷵻ص�ҳ�棬��ǰ��  �ص�Ϊindex.jspҳ��
        return "index";
    }

    @RequestMapping(value = "/admin/users", method = RequestMethod.GET)
    public String getUser(ModelMap modelMap) {
        //��ѯuser�������м�¼
        List<UserEntity> userEntityList = userRepository.findAll();

        //�����еļ�¼����Ҫ���ص�jspҳ�棬����userList��
        modelMap.addAttribute("userList", userEntityList);

        //���ص�pagesĿ¼�µ�admin/users.jsp
        return "admin/users";
    }

    //get���󣬷�������û�ҳ��
    @RequestMapping(value = "/admin/users/add", method = RequestMethod.GET)
    public String addUser() {
        //ת�� admin/addUser.jspҳ��
        return "admin/addUser";
    }

    //post���󣬴����û�������󣬲��ض����û�����
    @RequestMapping(value = "/admin/users/addP", method = RequestMethod.POST)
    public String addUserPost(@ModelAttribute("user") UserEntity userEntity) {
        // ע��˴���post���󴫵ݹ�������һ��UserEntity������������˸��û�����Ϣ
        // ͨ��@ModelAttribute()ע����Ի�ȡ���ݹ�����'user'���������������

        // ���ݿ������һ���û����ò���ʱ����ˢ�»���
        //userRepository.save(userEntity);

        // ���ݿ������һ���û���������ˢ�»���
        userRepository.saveAndFlush(userEntity);

        // �ض����û�����ҳ�棬����Ϊ redirect:url
        return "redirect:/admin/users";
    }

    //�鿴�û�����
    //@PathVariable�����ռ�url�еı�������ƥ��ı�����{}������
    // ���磺���� localhost:8080/admin/users/show/1 ����ƥ�� id = 1
    @RequestMapping(value = "/admin/users/show/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable("id") Integer userId, ModelMap modelMap) {
        //�ҵ�userId����ʾ���û�
        UserEntity userEntity = userRepository.findOne(userId);

        //���ݸ������ҳ��
        modelMap.addAttribute("user", userEntity);
        return "admin/userDetail";
    }

    // �����û���Ϣ ҳ��
    @RequestMapping(value = "/admin/users/update/{id}", method = RequestMethod.GET)
    public String updateUser(@PathVariable("id") Integer userId, ModelMap modelMap) {

        // �ҵ�userId����ʾ���û�
        UserEntity userEntity = userRepository.findOne(userId);

        // ���ݸ�����ҳ��
        modelMap.addAttribute("user", userEntity);
        return "admin/updateUser";
    }

    @RequestMapping(value = "/admin/users/updateP/{id}", method = RequestMethod.POST)
    public String updateUserPost(@ModelAttribute("userP") UserEntity userEntity) {

        //�����û���Ϣ
        userRepository.updateUser(userEntity.getUsername(), userEntity.getFirstName(), userEntity.getLastName(), userEntity.getPassword(), userEntity.getId());

        userRepository.flush();
        return "redirect:/admin/users/show/{id}";
    }

    //ɾ���û�
    @RequestMapping(value = "/admin/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable("id") Integer userId) {

        //ɾ��idΪuserId���û�
        userRepository.delete(userId);

        //����ˢ��
        userRepository.flush();
        return "redirect:/admin/users";
    }
}
