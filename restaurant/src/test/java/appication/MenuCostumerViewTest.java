package appication;

/*
 * The purpose of this class was to create test for testing the interfaces. Unfortunately I could
 * not figure out to setup the test properly. More specifically, while tests ran, they failed due to
 * the absence of a claenup function. Due to outdated documentation, I could not figure out how to
 * create said function.
 */
// import java.util.concurrent.TimeoutException;
//
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.testfx.api.FxRobot;
// import org.testfx.api.FxToolkit;
// import org.testfx.assertions.api.Assertions;
// import org.testfx.framework.junit5.ApplicationExtension;
// import org.testfx.framework.junit5.Start;
// import javafx.scene.control.Button;
// import javafx.stage.Stage;
//
// @ExtendWith(ApplicationExtension.class)
// class ClickableButtonTest_JUnit5AssertJ {
//
//
// private static Driver driver;
//
// /**
// * Will be called with {@code @Before} semantics, i. e. before each test method.
// *
// * @param stage - Will be injected by the test runner.
// * @throws Exception
// */
// @Start
// private void start(Stage stage) throws Exception {
//
// driver = new Driver();
// driver.start(stage);
// }
//
//
// private void cleanUpApplication() throws TimeoutException {
// FxToolkit.cleanupApplication(driver);
// }
//
// /**
// * @param robot - Will be injected by the test runner.
// */
// @Test
// void should_contain_button_with_text(FxRobot robot) {
// Assertions.assertThat(robot.lookup("#GoToPage2Button").queryAs(Button.class))
// .hasText("Go to page 2");
// // or (lookup by css id):
// // Assertions.assertThat(robot.lookup("#myButton").queryAs(Button.class)).hasText("click me!");
// // or (lookup by css class):
// // Assertions.assertThat(robot.lookup(".button").queryAs(Button.class)).hasText("click me!");
// // or (query specific type):
// // Assertions.assertThat(robot.lookup(".button").queryButton()).hasText("click me!");
// }
// }
