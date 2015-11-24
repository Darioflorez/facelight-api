package com.lab.serverdevelopment.handlers;


import com.lab.serverdevelopment.ViewModels.MessageViewModel;
import com.lab.serverdevelopment.ViewModels.UserViewModel;
import com.lab.serverdevelopment.dao.MessageDAO;
import com.lab.serverdevelopment.dao.UserDAO;
import com.lab.serverdevelopment.forms.MessageForm;
import com.lab.serverdevelopment.models.Message;
import com.lab.serverdevelopment.models.MessageType;
import com.lab.serverdevelopment.models.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dario on 2015-11-11.
 */
public class MessageHandler {

    private static MessageDAO messageDAO = new MessageDAO();
    private static UserDAO userDAO = new UserDAO();

    public static List<MessageViewModel> getPublicMessages(Long userId){
        List<Message> receivedMessages = messageDAO.getReceivedMessages(userId);
        List<Message> sendMessages = messageDAO.getSendMessages(userId);

        return messageListToMessageViewModelList(receivedMessages,sendMessages,MessageType.PUBLIC );
    }

    public static List<MessageViewModel> getPrivateMessages(Long userId){
        List<Message> receivedMessages = messageDAO.getReceivedMessages(userId);
        List<Message> sendMessages = messageDAO.getSendMessages(userId);

        return messageListToMessageViewModelList(receivedMessages,sendMessages,MessageType.PRIVATE );
    }

    public static boolean createMessage(MessageForm message){

        User sender = userDAO.getUser(message.getSender());
        User receiver = userDAO.getUser(message.getReceiver());

        Message messageNew = new Message();
        messageNew.setSender(sender);
        messageNew.setReceiver(receiver);
        messageNew.setType(message.getType());
        messageNew.setSubject(message.getSubject());
        messageNew.setContent(message.getContent());
        messageNew.setCreatedAt(new Date());
        Message created = messageDAO.create(messageNew);

        return (created != null);
    }

    private static List<MessageViewModel> messageListToMessageViewModelList(List<Message> receivedMessages,
                                                                            List<Message> sendMessages,
                                                                            MessageType type){
        ArrayList<MessageViewModel> userMessages = new ArrayList<>();
        receivedMessages
                .stream()
                .filter(m -> m.getType().equals(type))
                .forEach(m -> addMessageToMessageBean(userMessages, m));

        sendMessages
                .stream()
                .filter(m -> m.getType().equals(type))
                .forEach(m -> addMessageToMessageBean(userMessages, m));

        return userMessages;
    }
    private static void addMessageToMessageBean(ArrayList<MessageViewModel> userMessages, Message m){
        MessageViewModel message = new MessageViewModel();
        UserViewModel sender = new UserViewModel(m.getSender().getId(),m.getSender().getFirstName(), m.getSender().getLastName());
        UserViewModel receiver = new UserViewModel(m.getReceiver().getId(),m.getReceiver().getFirstName(), m.getReceiver().getLastName());

        message.setType(m.getType());
        message.setSubject(m.getSubject());
        message.setContent(m.getContent());
        message.setReceiver(receiver);
        message.setSender(sender);
        //Format message
        message.setCreatedAt(m.getCreatedAt().toString());
        System.out.println("MESSAGE FROM SAVE TO ARRAY: " + m.getSender().getFirstName());
        userMessages.add(message);
    }

}
