package com.coroda.util;

public class Constants {
    public final static String MAIN_PATH = "/person";
    public final static String ID = "id/{idPerson}";
    public final static String NUMBER_DOCUMENT = "/{numberDocument}";
    public final static String BODY_LIST_DNI = "/listdni";
    public final static String EMAIL = "email/{email}";

    public final static String SAVE_VALUE="Metodo a traves del cual se envia la informacion del Perfil que  sera registrada dentro de la base de datos";
    public final static String SAVE_NOTE="Para el registro del Perfil , sera necesario el llenado de todo los campos , a excepcion de los Id´s los cuales seran generados automaticamente";
    public final static String DELETE_ID_VALUE="Metodo a traves del cual se Elimina la informacion del Perfil mediante su Id ";
    public final static String DELETE_ID_NOTE="Para eliminar los  datos del Perfil , sera necesario enviar el Id del Perfil ";
    public final static String UPDATE_ID_VALUE="Metodo a traves del cual se Actualiza la informacion del Perfil mediante su Id ";
    public final static String UPDATE_ID_NOTE="Para Actualizar los  datos de un Perfil , sera necesario enviar todo el registro con los datos ya actualizados junto a sus Id`s ";
    public final static String GET_ID_VALUE="Metodo a traves del cual se Obtiene la informacion del Perfil mediante su Id ";
    public final static String GET_ID_NOTE="Para la obtencion de datos de un Perfil , sera necesario enviar el Id del Producto a consultar";

    public final static String GETDATA_VALUE="Metodo a traves del cual se Obtiene la informacion del Perfil ";
    public final static String GETDATA_NOTE="Para la obtencion de datos del Perfil ";
    public final static String GETEMAIL_VALUE="Metodo a traves del cual se Obtiene la informacion del Perfil a travez del email ";
    public final static String GETEMAIL_NOTE="Para la obtencion de datos del Perfil es necesario enviar el email de la persona ";

}
