/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package menuframework;

/**
 *
 * @author 6235181
 */
public interface Menuable<OptionType  extends MenuOptionType> {
    Menu<MenuOptionType> getMenu();
}
