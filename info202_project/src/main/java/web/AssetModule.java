/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import org.jooby.Jooby;
import org.jooby.Results;

/**
 *
 * @author User
 */
public class AssetModule extends Jooby{
    public AssetModule() {
      assets("/account.html");
		assets("/index.html");
		assets("/account.html");
		assets("/menu.html");
		assets("/products.html");
		assets("/quantity.html");
		assets("/shoppingcart.html");
		assets("/signin.html");
		assets("/thankyou.html");
      assets("/css/style.css");
      assets("/js/shopping.js");
      assets("/images/*.png");
      assets("/images/0.jpg");

      // make index.html the default page
      assets("/", "index.html");

      // prevent 404 errors due to browsers requesting favicons
      get("/favicon.ico", () -> Results.noContent());
    }

}

