package be.vdab.web;

import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/") 
class IndexController 
{
	private static final String VIEW = "index";
	public static final String GROET_KEY = "groet";

	/*
@GetMapping
String index()
{
return VIEW;
}


@GetMapping
ModelAndView index()
{
ModelAndView modelAndView = new ModelAndView(VIEW);
switch (Calendar.getInstance().get(Calendar.HOUR_OF_DAY))
{
case 0: case 1: case 2: case 3: case 4: case 5:
modelAndView.addObject(GROET_KEY, "goedeNacht");
break;
case 6: case 7: case 8: case 9: case 10: case 11:
modelAndView.addObject(GROET_KEY, "goedeMorgen");
break;
case 12: case 13: case 14: case 15: case 16: case 17:
modelAndView.addObject(GROET_KEY, "goedeMiddag");
break;
default:
modelAndView.addObject(GROET_KEY, "goedeAvond");
}
return modelAndView;
}
	 */

	@GetMapping
	ModelAndView index()
	{
		ModelAndView modelAndView = new ModelAndView(VIEW);
		int uur = LocalTime.now().getHour();
		if (uur < 6)
		{
			modelAndView.addObject(GROET_KEY, "goedeNacht");
		}
		else
			if (uur < 12)
			{
				modelAndView.addObject(GROET_KEY, "goedeMorgen");
			}
			else
				if (uur < 18)
				{
					modelAndView.addObject(GROET_KEY, "goedeMiddag");
				}
				else
				{
					modelAndView.addObject(GROET_KEY, "goedeAvond");
				}

		return modelAndView;
	}

}
