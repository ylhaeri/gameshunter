package br.com.gameshunter.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;

@Actions(value = {

@Action(value = "/", results = {

@Result(name = "ok", location = "home.jsp") }),

@Action(value = "home", results = {

@Result(name = "ok", location = "home.jsp") }),

@Action(value = "inicio", results = {

@Result(name = "ok", location = "home.jsp") }) })
public class InicioAction {

	public String execute() {
		return "ok";
	}
}