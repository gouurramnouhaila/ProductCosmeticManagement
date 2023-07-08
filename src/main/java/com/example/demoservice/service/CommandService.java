package com.example.demoservice.service;

import com.example.demoservice.model.Command;
import com.example.demoservice.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandService {

    private final CommandRepository commandRepository;

    @Autowired
    public CommandService(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    public Command getCommandById(Long id) {
        return commandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Command not found with id: " + id));
    }

    public Command createCommand(Command command) {
        return commandRepository.save(command);
    }

    public Command updateCommand(Long id, Command command) {
        Command existingCommand = getCommandById(id);
        existingCommand.setUser(command.getUser());
        existingCommand.setProducts(command.getProducts());
        existingCommand.setDate(command.getDate());
        return commandRepository.save(existingCommand);
    }

    public void deleteCommand(Long id) {
        Command command = getCommandById(id);
        commandRepository.delete(command);
    }
}

