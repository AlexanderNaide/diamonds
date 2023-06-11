module org.satal.diamonds {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
//    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
//    requires com.almasb.fxgl.all;

    requires lombok;
//    requires spring.context;
//    requires spring.core;
//    requires spring.aop;
//    requires spring.beans;
//    requires java.annotation;

    opens org.satal.diamonds to javafx.fxml;
    exports org.satal.diamonds;

    exports org.satal.diamonds.controller;
    opens org.satal.diamonds.controller to javafx.fxml;

    exports org.satal.diamonds.view;
    opens org.satal.diamonds.view to javafx.fxml;

    exports org.satal.diamonds.view.gemeView;
    opens org.satal.diamonds.view.gemeView;

    exports org.satal.diamonds.properties;
    opens org.satal.diamonds.properties;

    exports org.satal.diamonds.model;
    opens org.satal.diamonds.model;
}