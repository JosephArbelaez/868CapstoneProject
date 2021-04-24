package com.example.C868CapstoneProject.Configuration;

import com.example.C868CapstoneProject.Repository.BookRepository;
import com.example.C868CapstoneProject.model.Book;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(BookRepository repository) {
		return args -> {
			Book watchmen = new Book(9781779501127L,
							"Watchmen", 
							"Alan Moore", 
							"Considered the greatest graphic novel in the history of the medium, the Hugo Award-winning story chronicles the fall from grace of a group of superheroes plagued by all-too-human failings. Along the way, the concept of the superhero is dissected as an unknown assassin stalks the erstwhile heroes.",
							416, 
							12.74,
							"Graphic Novels",
							false);
				Book unstoppable =new Book(9781250007148L,
							"Unstoppable",
							"Bill Nye",
							"In UNSTOPPABLE, Bill Nye crystallizes and expands the message for which he is best known and beloved. That message is that with a combination of optimism and scientific curiosity, all obstacles become opportunities, and the possibilities of our world become limitless. With a scientist's thirst for knowledge and an engineer's vision of what can be, Bill Nye sees today's environmental issues not as insurmountable, depressing problems but as chances for our society to rise to the challenge and create a cleaner, healthier, smarter world. We need not accept that transportation consumes half our energy, and that two-thirds of the energy you put into your car is immediately thrown away out the tailpipe. We need not accept that dangerous emissions are the price we must pay for a vibrant economy and a comfortable life. Above all, we need not accept that we will leave our children a planet that is dirty, overheated, and depleted of resources. As Bill shares his vision, he debunks some of the most persistent myths and misunderstandings about global warming. When you are done reading, you'll be enlightened and empowered. Chances are, you'll be smiling, too, ready to join Bill and change the world.",
							368,
							17.99,
							"NonFiction",
							false);
				Book book = new Book(9870316017923L,
						"Outliers",
						"Malcolm Gladwell",
						"In this stunning book, Malcolm Gladwell takes us on an intellectual journey through the world of \"outliers\"--the best and the brightest, the most famous and the most successful. He asks the question: what makes high-achievers different?\n"
						+ "\n"
						+ "His answer is that we pay too much attention to what successful people are like, and too little attention to where they are from: that is, their culture, their family, their generation, and the idiosyncratic experiences of their upbringing. Along the way he explains the secrets of software billionaires, what it takes to be a great soccer player, why Asians are good at math, and what made the Beatles the greatest rock band.\n"
						+ "\n"
						+ "Brilliant and entertaining, Outliers is a landmark work that will simultaneously delight and illuminate.",
						321,
						16.99,
						"NonFiction",
						true);
				repository.save(watchmen);
				repository.save(unstoppable);
				repository.save(book);
				};
	}
}
