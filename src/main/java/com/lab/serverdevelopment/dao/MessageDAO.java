package com.lab.serverdevelopment.dao;


import com.lab.serverdevelopment.dao.generics.GenericDaoImpl;
import com.lab.serverdevelopment.models.Message;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import java.util.List;

/**
 * Created by dario on 2015-11-07.
 */
public class MessageDAO extends GenericDaoImpl<Message> {

    public List<Message> getReceivedMessages(Long userId){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        List<Message> receivedMessages = null;
        try{
            receivedMessages = em.createQuery("select message from Message message" +
                    " where message.receiver.id = ?1" +
                    " order by message.createdAt", Message.class)
                    .setParameter(1,userId)
                    .getResultList();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return receivedMessages;
    }

    public List<Message> getSendMessages(Long userId){
        EntityManager em = EntityManagerUtil.getEntityManager().createEntityManager();
        List<Message> receivedMessages = null;
        try{
            receivedMessages = em.createQuery("select message from Message message" +
                    " where message.sender.id = ?1" +
                    " order by message.createdAt", Message.class)
                    .setParameter(1,userId)
                    .getResultList();
        }catch (NoResultException e){
            System.out.println(e.getMessage());
        }finally {
            em.close();
        }
        return receivedMessages;
    }

}
