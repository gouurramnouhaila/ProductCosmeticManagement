package com.example.demoservice.controller;

import com.example.demoservice.model.Command;
import com.example.demoservice.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commands")
public class CommandController {

    private final CommandService commandService;

    @Autowired
    public CommandController(CommandService commandService) {
        this.commandService = commandService;
    }

    @GetMapping
    public List<Command> getAllCommands() {
        return commandService.getAllCommands();
    }

    @GetMapping("/{id}")
    public Command getCommandById(@PathVariable Long id) {
        return commandService.getCommandById(id);
    }

    @PostMapping
    public Command createCommand(@RequestBody Command command) {
        return commandService.createCommand(command);
    }

    @PutMapping("/{id}")
    public Command updateCommand(@PathVariable Long id, @RequestBody Command command) {
        return commandService.updateCommand(id, command);
    }

    @DeleteMapping("/{id}")
    public void deleteCommand(@PathVariable Long id) {
        commandService.deleteCommand(id);
    }
}
