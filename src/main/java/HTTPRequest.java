import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;


public class HTTPRequest {

    public void downloadFileByUrlAndFile(String urlContent, String fileDirectory) {

        try {

            URL url = new URL(urlContent);
            System.out.println(url.getPath());
            File file = new File(fileDirectory);
            FileUtils.copyURLToFile(url, file);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void RequestSession() {
        /* Simulação de um browser por HtmlUnit */
        final WebClient webClient = new WebClient(BrowserVersion.CHROME);

        /* Desabilita o JS e o CSS da página */
        webClient.getOptions().setJavaScriptEnabled(false);
        webClient.getOptions().setCssEnabled(false);

        /* cookieManager para gerenciar os dados da sessão */
        CookieManager cookieManager = new CookieManager();
        cookieManager = webClient.getCookieManager();

        /* Requisição de dados */
        try {

            HtmlPage page = webClient
                    .getPage("https://github.com/login");

            /* Recupera o formulário por nome ou todos*/
            HtmlForm form = page.getFormByName("");

            /* Atribui os dados de acordo com a tag */
            HtmlTextInput textInput = form.getInputByName("login");
            HtmlPasswordInput passwordInput = form.getInputByName("password");
            textInput.setValueAttribute("*");
            passwordInput.setValueAttribute("*");

            /* Simula o click */
            final HtmlPage answerPage = (HtmlPage) form.getInputByValue("Sign in").click();

            /* Retorna o resultado*/
            //answerPage.getWebResponse();
            String result = webClient.getPage("https://github.com/Stanniack?tab=repositories").getWebResponse().getContentAsString();
            System.out.println(result);

            //System.out.println(form.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
