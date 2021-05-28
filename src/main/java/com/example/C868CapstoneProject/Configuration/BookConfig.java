package com.example.C868CapstoneProject.Configuration;

import com.example.C868CapstoneProject.Repository.BookRepository;
import com.example.C868CapstoneProject.Repository.PersonRepository;
import com.example.C868CapstoneProject.model.Book;
import com.example.C868CapstoneProject.model.Person;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        List<Book> BookList = new ArrayList<Book>();
        return args -> {
            BookList.add(new Book(9781779501127L,
                    "watchmen",
                    "Alan Moore",
                    "Considered the greatest graphic novel in the history of the medium, the Hugo Award-winning story chronicles the fall from grace of a group of superheroes plagued by all-too-human failings. Along the way, the concept of the superhero is dissected as an unknown assassin stalks the erstwhile heroes.",
                    416,
                    12.74,
                    "Graphic Novels",
                    null,
                    "https://images-na.ssl-images-amazon.com/images/I/410D4H0IqjL._SX318_BO1,204,203,200_.jpg"));
            BookList.add(new Book(9781250007148L,
                    "unstoppable",
                    "Bill Nye",
                    "In UNSTOPPABLE, Bill Nye crystallizes and expands the message for which he is best known and beloved. That message is that with a combination of optimism and scientific curiosity, all obstacles become opportunities, and the possibilities of our world become limitless. With a scientist's thirst for knowledge and an engineer's vision of what can be, Bill Nye sees today's environmental issues not as insurmountable, depressing problems but as chances for our society to rise to the challenge and create a cleaner, healthier, smarter world. We need not accept that transportation consumes half our energy, and that two-thirds of the energy you put into your car is immediately thrown away out the tailpipe. We need not accept that dangerous emissions are the price we must pay for a vibrant economy and a comfortable life. Above all, we need not accept that we will leave our children a planet that is dirty, overheated, and depleted of resources. As Bill shares his vision, he debunks some of the most persistent myths and misunderstandings about global warming. When you are done reading, you'll be enlightened and empowered. Chances are, you'll be smiling, too, ready to join Bill and change the world.",
                    368,
                    17.99,
                    "NonFiction",
                    null,
                    "https://pictures.abebooks.com/isbn/9781250007148-us.jpg"
            ));
            BookList.add(new Book(1406361801L,
                    "a monster calls",
                    "Patrick Ness",
					"Thirteen-year-old Conor awakens one night to find a monster outside his bedroom window, but not the one from the recurring nightmare that began when his mother became ill--an ancient, wild creature that wants him to face truth and loss.",
					237,
                    13.57,
                    "Fiction",
                    null,
                    "https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1430763000l/25480342.jpg"));
			BookList.add(new Book(8340749L,
					"the wave",
					"Virginia Moffatt",
					"A devastating tsunami is heading towards the Cornish coast. With no early warning and limited means of escape, many people won’t get away in time. \n" +
							"While the terrifying reality of the news hits home, one young woman posts a message on Facebook, ‘With nowhere to run to, I’m heading to my favourite beach to watch the sunset, who wants to join me?’ A small group of people follow her lead and head towards the beach; each of them are harbouring their own stories ̶ and their own secrets.\n" +
							"As they come together in the dying light of the Cornish sunset, they will discover something much more powerful than they ever imagined. But there is no escaping the dawn… the wave is coming…",
					386,
					15.99,
					"Fiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1557853852l/45784620._SY475_.jpg"));
			BookList.add(new Book(316017930L,
					"outliers",
					"Malcolm Gladwell",
					"In this stunning book, Malcolm Gladwell takes us on an intellectual journey through the world of \"outliers\"--the best and the brightest, the most famous and the most successful. He asks the question: what makes high-achievers different?\n"
							+ "\n"
							+ "His answer is that we pay too much attention to what successful people are like, and too little attention to where they are from: that is, their culture, their family, their generation, and the idiosyncratic experiences of their upbringing. Along the way he explains the secrets of software billionaires, what it takes to be a great soccer player, why Asians are good at math, and what made the Beatles the greatest rock band.\n"
							+ "\n"
							+ "Brilliant and entertaining, Outliers is a landmark work that will simultaneously delight and illuminate.",
					321,
					16.99,
					"NonFiction",
					null,
					"https://images-na.ssl-images-amazon.com/images/I/41LO6QRvIuL._SX331_BO1,204,203,200_.jpg"));
			BookList.add(new Book(1473637465L,
					"factfulness: ten reasons we're wrong about the world – and why things are better than you think",
					"Hans Rosling, Ola Rosling, Anna Rosling Rönnlund",
					"When asked simple questions about global trends - why the world's population is increasing; how many young women go to school; how many of us live in poverty - we systematically get the answers wrong. So wrong that a chimpanzee choosing answers at random will consistently outguess journalists, Nobel laureates, and investment bankers.\n" +
							"\n" +
							"In Factfulness, Professor of International Health and a man who can make data sing, Hans Rosling, together with his two long-time collaborators Anna and Ola, offers a radical new explanation of why this happens, and reveals the ten instincts that distort our perspective.\n" +
							"\n" +
							"It turns out that the world, for all its imperfections, is in a much better state than we might think. But when we worry about everything all the time instead of embracing a worldview based on facts, we can lose our ability to focus on the things that threaten us most.\n" +
							"\n" +
							"Inspiring and revelatory, filled with lively anecdotes and moving stories, Factfulness is an urgent and essential book that will change the way you see the world.",
					342,
					16.50,
					"NonFiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1544963815l/34890015._SY475_.jpg"));
			BookList.add(new Book(316075558L,
					"the black prism",
					"Brent Weeks",
					"Guile is the Prism, the most powerful man in the world. He is high priest and emperor, a man whose power, wit, and charm are all that preserves a tenuous peace. Yet Prisms never last, and Guile knows exactly how long he has left to live.\n" +
							"\n" +
							"When Guile discovers he has a son, born in a far kingdom after the war that put him in power, he must decide how much he's willing to pay to protect a secret that could tear his world apart.",
					629,
					9.40,
					"Fiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1327921884l/7165300.jpg"));
			BookList.add(new Book(525536299L,
					"the vanishing half",
					"Brit Bennett",
					"Longlisted for the National Book Award, Brit Bennett’s ambitious novel follows two identical twin sisters from a small Southern town. One stays home in her Black community; the other passes for white in the wider world. Provocative and compassionate, Bennett’s book traces fascinating threads of American identity and is our hands-down winner for the 2020 Historical Fiction award.",
					343,
					16.20,
					"Fiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1577090827l/51791252._SX318_SY475_.jpg"));
			BookList.add(new Book(1250762847L,
					"to sleep in a sea of stars",
					"Christopher Paolini",
					"Author Christopher Paolini earns his first Goodreads Choice Award with this sustained gaze into the future of humankind. While scouting an as-yet-uncolonized planet, scientist Kira Navárez discovers an alien relic that will change the fate of Earth and its colonies. A resounding critical and commercial success, Paolini’s innovative story brings delightful new twists to the venerable “first contact” sci-fi template.",
					878,
					14.99,
					"Fiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1583523112l/48829708.jpg"));
			BookList.add(new Book(316453692L,
					"stamped: racism, antiracism and you",
					"Jason Reynolds, Ibram X. Kendi",
					"A timely, crucial, and empowering exploration of racism--and antiracism--in America.\n" +
							"\n" +
							"This is NOT a history book.\n" +
							"This is a book about the here and now.\n" +
							"A book to help us better understand why we are where we are.\n" +
							"A book about race.\n" +
							"\n" +
							"The construct of race has always been used to gain and keep power, to create dynamics that separate and silence. This is a remarkable reimagining of Dr. Ibram X. Kendi's Stamped from the Beginning, winner of a National Book Award. It reveals the history of racist ideas in America and inspires hope for an antiracist future.\n" +
							"\n" +
							"Stamped takes you on a race journey from then to now, shows you why we feel how we feel, and why the poison of racism lingers. It also proves that while racist ideas have always been easy to fabricate and distribute, they can also be discredited.\n" +
							"\n" +
							"Through a gripping, fast-paced, and energizing narrative, Jason Reynolds shines a light on the many insidious forms of racist ideas--and on ways readers can identify and stamp out racist thoughts in their daily lives.",
					294,
					8.99,
					"NonFiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1568739320l/52220686._SX318_SY475_.jpg"));
			BookList.add(new Book(316017930L,
					"caste: the origins of discontents",
					"Isabel Wilkerson",
					"The Pulitzer Prize–winning, bestselling author of The Warmth of Other Suns examines the unspoken caste system that has shaped America and shows how our lives today are still defined by a hierarchy of human divisions.\n" +
							"\n" +
							"“As we go about our daily lives, caste is the wordless usher in a darkened theater, flashlight cast down in the aisles, guiding us to our assigned seats for a performance. The hierarchy of caste is not about feelings or morality. It is about power—which groups have it and which do not.”\n" +
							"\n" +
							"In this brilliant book, Isabel Wilkerson gives us a masterful portrait of an unseen phenomenon in America as she explores, through an immersive, deeply researched narrative and stories about real people, how America today and throughout its history has been shaped by a hidden caste system, a rigid hierarchy of human rankings.\n" +
							"\n" +
							"Beyond race, class, or other factors, there is a powerful caste system that influences people’s lives and behavior and the nation’s fate. Linking the caste systems of America, India, and Nazi Germany, Wilkerson explores eight pillars that underlie caste systems across civilizations, including divine will, bloodlines, stigma, and more. Using riveting stories about people—including Martin Luther King, Jr., baseball’s Satchel Paige, a single father and his toddler son, Wilkerson herself, and many others—she shows the ways that the insidious undertow of caste is experienced every day. She documents how the Nazis studied the racial systems in America to plan their out-cast of the Jews; she discusses why the cruel logic of caste requires that there be a bottom rung for those in the middle to measure themselves against; she writes about the surprising health costs of caste, in depression and life expectancy, and the effects of this hierarchy on our culture and politics. Finally, she points forward to ways America can move beyond the artificial and destructive separations of human divisions, toward hope in our common humanity.",
					496,
					18.75,
					"NonFiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1597267568l/51152447._SY475_.jpg"));
			BookList.add(new Book(9781538719985L,
					"a life on our planet: my witness statement and a vision for the future",
					"David Attenborough",
					"I am 94. I've had an extraordinary life. It's only now that I appreciate how extraordinary.\n" +
							"\n" +
							"As a young man, I felt I was out there in the wild, experiencing the untouched natural world - but it was an illusion. The tragedy of our time has been happening all around us, barely noticeable from day to day - the loss of our planet's wild places, its biodiversity.\n" +
							"\n" +
							"I have been witness to this decline. A Life on Our Planet is my witness statement, and my vision for the future. It is the story of how we came to make this, our greatest mistake - and how, if we act now, we can yet put it right.\n" +
							"\n" +
							"We have one final chance to create the perfect home for ourselves and restore the wonderful world we inherited.\n" +
							"\n" +
							"All we need is the will to do so.",
					272,
					19.59,
					"NonFiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1608723131l/53916142._SY475_.jpg"));
			BookList.add(new Book(9781524763169L,
					"a promised land",
					"Barack Obama",
					"A riveting, deeply personal account of history in the making—from the president who inspired us to believe in the power of democracy.\n" +
							"\n" +
							"In the stirring, highly anticipated first volume of his presidential memoirs, Barack Obama tells the story of his improbable odyssey from young man searching for his identity to leader of the free world, describing in strikingly personal detail both his political education and the landmark moments of the first term of his historic presidency—a time of dramatic transformation and turmoil.\n" +
							"\n" +
							"Obama takes readers on a compelling journey from his earliest political aspirations to the pivotal Iowa caucus victory that demonstrated the power of grassroots activism to the watershed night of November 4, 2008, when he was elected 44th president of the United States, becoming the first African American to hold the nation’s highest office.\n" +
							"\n" +
							"Reflecting on the presidency, he offers a unique and thoughtful exploration of both the awesome reach and the limits of presidential power, as well as singular insights into the dynamics of U.S. partisan politics and international diplomacy. Obama brings readers inside the Oval Office and the White House Situation Room, and to Moscow, Cairo, Beijing, and points beyond. We are privy to his thoughts as he assembles his cabinet, wrestles with a global financial crisis, takes the measure of Vladimir Putin, overcomes seemingly insurmountable odds to secure passage of the Affordable Care Act, clashes with generals about U.S. strategy in Afghanistan, tackles Wall Street reform, responds to the devastating Deepwater Horizon blowout, and authorizes Operation Neptune’s Spear, which leads to the death of Osama bin Laden.\n" +
							"\n" +
							"A Promised Land is extraordinarily intimate and introspective—the story of one man’s bet with history, the faith of a community organizer tested on the world stage. Obama is candid about the balancing act of running for office as a Black American, bearing the expectations of a generation buoyed by messages of “hope and change,” and meeting the moral challenges of high-stakes decision-making. He is frank about the forces that opposed him at home and abroad, open about how living in the White House affected his wife and daughters, and unafraid to reveal self-doubt and disappointment. Yet he never wavers from his belief that inside the great, ongoing American experiment, progress is always possible.\n" +
							"\n" +
							"This beautifully written and powerful book captures Barack Obama’s conviction that democracy is not a gift from on high but something founded on empathy and common understanding and built together, day by day.",
					751,
					17.73,
					"NonFiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1604286292l/55359022._SY475_.jpg"));
			BookList.add(new Book(9780544387652L,
					"the secret to superhuman strength",
					"Alison Bechdel",
					"Comics and cultural superstar Alison Bechdel delivers a deeply layered story of her fascination, from childhood to adulthood, with every fitness craze to come down the pike: from Jack LaLanne in the 60s (\"Outlandish jumpsuit! Cantaloupe-sized guns!\") to the existential oddness of present-day spin class. Readers will see their athletic or semi-active pasts flash before their eyes through an ever-evolving panoply of running shoes, bicycles, skis, and sundry other gear. But the more Bechdel tries to improve herself, the more her self appears to be the thing in her way. She turns for enlightenment to Eastern philosophers and literary figures, including Beat writer Jack Kerouac, whose search for self-transcendence in the great outdoors appears in moving conversation with the author’s own. This gifted artist and not-getting-any-younger exerciser comes to a soulful conclusion. The secret to superhuman strength lies not in six-pack abs, but in something much less clearly defined: facing her own non-transcendent but all-important interdependence with others.\n" +
							"\n" +
							"A heartrendingly comic chronicle for our times.",
					240,
					19.99,
					"Graphic Novels",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1603447250l/53968436.jpg"));
			BookList.add(new Book(385689225L,
					"born a crime: stories from a south african childhood",
					"Trevor Noah",
					"The memoir of one man’s coming-of-age, set during the twilight of apartheid and the tumultuous days of freedom that followed.\n" +
							"\n" +
							"Trevor Noah’s unlikely path from apartheid South Africa to the desk of The Daily Show began with a criminal act: his birth. Trevor was born to a white Swiss father and a black Xhosa mother at a time when such a union was punishable by five years in prison. Living proof of his parents’ indiscretion, Trevor was kept mostly indoors for the earliest years of his life, bound by the extreme and often absurd measures his mother took to hide him from a government that could, at any moment, steal him away. Finally liberated by the end of South Africa’s tyrannical white rule, Trevor and his mother set forth on a grand adventure, living openly and freely and embracing the opportunities won by a centuries-long struggle.\n" +
							"\n" +
							"Born a Crime is the story of a mischievous young boy who grows into a restless young man as he struggles to find himself in a world where he was never supposed to exist. It is also the story of that young man’s relationship with his fearless, rebellious, and fervently religious mother—his teammate, a woman determined to save her son from the cycle of poverty, violence, and abuse that would ultimately threaten her own life.",
					289,
					49.91,
					"NonFiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1473867911l/29780253.jpg"));
			BookList.add(new Book(63079372L,
					"remote, inc.: how to thrive at work... wherever you are",
					"Robert C. Pozen",
					"It’s not enough to stay sane while you’re working from home: You deserve to thrive and excel. But that’s hard to do when you, your boss or your team are still trying to replicate the way you work at the office, enduring an endless series of video calls while pretending that yes, everyone is wearing pants.\n" +
							"\n" +
							"Remote, Inc. shows you a new approach, based on the mindset and habits of people who flourish while working outside the office some or all of the time.  These are the folks who manage to get even more done at home, even though you know they’ve got kids or dogs underfoot and somehow fit in a daily run at lunchtime. \n" +
							"\n" +
							"Their secret? They think like a “business of one.” That’s how productivity experts Robert C. Pozen and Alexandra Samuel describe the mindset that lets people thrive when they’re working remotely, whether working from home full-time or spending a few days each week in the office. You can follow their lead by embracing the work habits and independence of an entrepreneur – while also tapping into the benefits of collegiality and online collaboration.\n" +
							"\n" +
							"Remote, Inc. maps out the principles that drive this entrepreneurial approach, and translates them into the specific habits and tools that make remote work productive and enjoyable. It shows you how to:\n" +
							"\n" +
							" * Focus on goals and results instead of the 9-to-5 schedule\n" +
							" * Wow your managers by treating them like valued clients\n" +
							" * Beat information overload with a system that prioritizes the most important emails and messages   \n" +
							" * Make online meetings purposeful, focused and engaging\n" +
							" * Learn to love your colleagues again by building great relationships through online collaboration\n" +
							" * Plan for success in a world in which many professionals will work remotely\n" +
							" * Just as important as making you a professional powerhouse, Remote Inc. will help you find a balance between work from home, and life at home.",
					304,
					22.01,
					"Self Help",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1602563263l/55507051.jpg"));
			BookList.add(new Book(9781538719961L,
					"the hero code: lessons learned from lives well lived",
					"William H. McRaven",
					"The Hero Code is Admiral McRaven's ringing tribute to the real, everyday heroes he's met over the years, from battlefields to hospitals to college campuses, who are doing their part to save the world.\n" +
							"\n" +
							"When Bill McRaven was a young boy growing up in Texas, he dreamed of being a superhero. He longed to put on a cape and use his superpowers to save the earth from destruction. But as he grew older and traveled the world, he found real heroes everywhere he went -- and none of them had superpowers. None of them wore capes or cowls. But they all possessed qualities that gave them the power to help others, to make a difference, to save the world: courage, both physical and moral; humility; a willingness to sacrifice; and a deep sense of integrity.\n" +
							"\n" +
							"The Hero Code is not a cypher, a puzzle, or a secret message. It is a code of conduct; lessons in virtues that can become the foundations of our character as we build a life worthy of honor and respect.",
					176,
					13.60,
					"NonFiction",
					null,
					"https://i.gr-assets.com/images/S/compressed.photo.goodreads.com/books/1615388642l/54817547.jpg"));

            for (int i = 0; i < BookList.size(); i++) {
                repository.save(BookList.get(i));
            }
        };
    }
}
