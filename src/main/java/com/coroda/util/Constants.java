package com.coroda.util;

public class Constants {
    public static final  String MAIN_PATH = "/person";
    public static final String ID = "id/{idPerson}";
    public static final String NUMBER_DOCUMENT = "/{numberDocument}";
    public static final String BODY_LIST_DNI = "/listdni";
    public static final String EMAIL = "email/{email}";

    public static final String SAVE_VALUE="Metodo a traves del cual se envia la informacion del Perfil que  sera registrada dentro de la base de datos";
    public static final String SAVE_NOTE="Para el registro del Perfil , sera necesario el llenado de todo los campos , a excepcion de los Id´s los cuales seran generados automaticamente";
    public static final String DELETE_ID_VALUE="Metodo a traves del cual se Elimina la informacion del Perfil mediante su Id ";
    public static final String DELETE_ID_NOTE="Para eliminar los  datos del Perfil , sera necesario enviar el Id del Perfil ";
    public static final String UPDATE_ID_VALUE="Metodo a traves del cual se Actualiza la informacion del Perfil mediante su Id ";
    public static final String UPDATE_ID_NOTE="Para Actualizar los  datos de un Perfil , sera necesario enviar todo el registro con los datos ya actualizados junto a sus Id`s ";
    public static final String GET_ID_VALUE="Metodo a traves del cual se Obtiene la informacion del Perfil mediante su Id ";
    public static final String GET_ID_NOTE="Para la obtencion de datos de un Perfil , sera necesario enviar el Id del Producto a consultar";

    public static final String GETDATA_VALUE="Metodo a traves del cual se Obtiene la informacion del Perfil ";
    public static final String GETDATA_NOTE="Para la obtencion de datos del Perfil ";
    public static final String GETEMAIL_VALUE="Metodo a traves del cual se Obtiene la informacion del Perfil a travez del email ";
    public static final String GETEMAIL_NOTE="Para la obtencion de datos del Perfil es necesario enviar el email de la persona ";

    private Constants() {
    }
}
