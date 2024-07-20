/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author lofts
 */
public class TerminalHandler {
  
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void print(String text) {
        System.out.println(text);
    }

    public void print_error(String text) {
        System.out.println("\u001B[31m" + text + "\u001B[0m");
    }

    public void print_success(String text) {
        System.out.println("\u001B[32m" + text + "\u001B[0m");
    }

    public void print_warning(String text) {
        System.out.println("\u001B[33m" + text + "\u001B[0m");
    }

    public void print_info(String text) {
        System.out.println("\u001B[34m" + text + "\u001B[0m");
    }

    public void print_debug(String text) {
        System.out.println("\u001B[35m" + text + "\u001B[0m");
    }

    public void print_custom(String text, String color) {
        System.out.println(color + text + "\u001B[0m");
    }

    public void print_custom(String text, String color, String background) {
        System.out.println(color + background + text + "\u001B[0m");
    }

    public void print_custom(String text, String color, String background, String style) {
        System.out.println(style + color + background + text + "\u001B[0m");
    }

    public void print_custom(String text, String color, String background, String style, String style_background) {
        System.out.println(style + style_background + color + background + text + "\u001B[0m");
    }

    public void print_custom(String text, String color, String background, String style, String style_background, String underline) {
        System.out.println(style + style_background + underline + color + background + text + "\u001B[0m");
    }

    public void print_custom(String text, String color, String background, String style, String style_background, String underline, String blink) {
        System.out.println(style + style_background + underline + blink + color + background + text + "\u001B[0m");
    }

    public void print_custom(String text, String color, String background, String style, String style_background, String underline, String blink, String hidden) {
        System.out.println(style + style_background + underline + blink + hidden + color + background + text + "\u001B[0m");
    }

}


