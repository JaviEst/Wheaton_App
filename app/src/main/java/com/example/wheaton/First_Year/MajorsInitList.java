package com.example.wheaton.First_Year;

import java.util.ArrayList;

public class MajorsInitList {

    public static String[] allMajorTitles(ArrayList<Major> majorList) {
        String[] output = new String[majorList.size()];
        for (int i = 0; i < majorList.size(); i++) {
            output[i] = majorList.get(i).getTitle();
        }

        return output;
    }

    public static ArrayList<Major> generateAllMajorsList() {
        ArrayList<Major> output = new ArrayList<Major>();
        Major newItem;


        newItem = new Major();
        newItem.setTitle("Africa, African American, Diaspora Studies");
        newItem.setCategory("History");
        newItem.setSummary("Explore the experiences of Africans and people of African descent—and the creative and intellectual contributions they’ve made around the world throughout the diaspora. This enriching program offers courses from across disciplines: art, music and literature; anthropology, psychology and sociology; economics and political science; and history. As an African studies major, you’ll also have the option to study abroad in Africa, the Caribbean and other destinations. This program is also available as a minor.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1744");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/aaads_april14-220x136.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("American Studies");
        newItem.setCategory("History");
        newItem.setSummary("These United States. Life in America is as complex as ever. In this interdisciplinary major, you’ll examine the ever-evolving American experience through multiple lenses: the arts, history, literature, culture, politics, social movements and more. You’ll build a foundation in U.S. history and also deepen your understanding of today’s most pertinent topics, such as race, ethnicity, gender and sexuality. As an American studies major, you’ll have the freedom to choose electives that fit your historical, cultural and literary interests.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1746");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/flag-1291945_640-300x210.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Ancient Studies (Grecko-Roman) ");
        newItem.setCategory("Classics");
        newItem.setSummary("Hebrew. Greek. Latin. Interpret ancient texts and uncover the religious and cultural history of the Mediterranean, including the traditions of Judaism and Christianity. In this interdisciplinary program, you can choose one of three tracks: Greco-Roman, Hebrew or the New Testament. You can further customize your studies by choosing electives that pique your curiosity, such as the faith and practice of Islam or Judaism, the thought of ancient philosophers such as Plato and Socrates, or an anthropology course devoted to the rise and fall of ancient Rome.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1747");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/Ancient-Studies-294x300.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Ancient Studies (Hebrew) ");
        newItem.setCategory("Classics");
        newItem.setSummary("Hebrew. Greek. Latin. Interpret ancient texts and uncover the religious and cultural history of the Mediterranean, including the traditions of Judaism and Christianity. In this interdisciplinary program, you can choose one of three tracks: Greco-Roman, Hebrew or the New Testament. You can further customize your studies by choosing electives that pique your curiosity, such as the faith and practice of Islam or Judaism, the thought of ancient philosophers such as Plato and Socrates, or an anthropology course devoted to the rise and fall of ancient Rome.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1747");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/Ancient-Studies-294x300.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Ancient Studies (New Testament) ");
        newItem.setCategory("Classics");
        newItem.setSummary("Hebrew. Greek. Latin. Interpret ancient texts and uncover the religious and cultural history of the Mediterranean, including the traditions of Judaism and Christianity. In this interdisciplinary program, you can choose one of three tracks: Greco-Roman, Hebrew or the New Testament. You can further customize your studies by choosing electives that pique your curiosity, such as the faith and practice of Islam or Judaism, the thought of ancient philosophers such as Plato and Socrates, or an anthropology course devoted to the rise and fall of ancient Rome.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1747");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/Ancient-Studies-294x300.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Anthropology Studies");
        newItem.setCategory("Anthropology");
        newItem.setSummary("What makes a human, human? Anthropology looks at the entire human experience: our biology, the way we think, how we evolved, what we eat, where we live and what we’re capable of achieving. With a vast selection of electives, you can choose to dig into archaeology of the Southwest, discover more about the peoples and cultures of the Himalayas, or examine the ecology and politics of food. As an anthropology major, you might find yourself immersed in another culture during a semester, summer or year abroad. You can also choose a public health track, which joins the social sciences and biology.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1749");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/05/Emily-DeWet3-1024x768-300x225.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Astronomy and Physics");
        newItem.setCategory("Physics and Astronomy");
        newItem.setSummary("Part life science, part chemical science, biochemistry looks at living things from the molecular level. Biochemistry is critical to health care, agriculture, the environment, energy and any industry or process that affects life. Today’s scientists need to communicate clearly with colleagues outside the lab; in this hands-on program you’ll develop the skills and know-how to present research for the scientific and lay communities. With its rigorous curriculum, the biochemistry major will prepare you well for a career in research, for medical or professional school, or for graduate study in the natural sciences");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1754");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/satellite-2594582_640-300x162.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Biochemistry");
        newItem.setCategory("Biology");
        newItem.setSummary("Part life science, part chemical science, biochemistry looks at living things from the molecular level. Biochemistry is critical to health care, agriculture, the environment, energy and any industry or process that affects life. Today’s scientists need to communicate clearly with colleagues outside the lab; in this hands-on program you’ll develop the skills and know-how to present research for the scientific and lay communities. With its rigorous curriculum, the biochemistry major will prepare you well for a career in research, for medical or professional school, or for graduate study in the natural sciences");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1754");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2013/04/570_Lee-Joseph-4-220x330.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Bioinformatics");
        newItem.setCategory("Biology");
        newItem.setSummary("Where big data meets biology you’ll find the exciting, emerging field of bioinformatics. This interdisciplinary major joins studies in biology, math, chemistry, computer science and statistics to prepare you for in-demand careers in research and data science. You will learn about the structure of both DNA and databases, and you’ll cover topics from algorithms and artificial intelligence to genome sequencing and cells. Bioinformatics majors explore possibilities in personalized medicine and drug discovery, as well as discuss the ethical implications and other challenges that come with collecting, analyzing, storing and using massive amounts of biological data.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1755");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2015/09/TOC1-220x165.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Biology");
        newItem.setCategory("Biology");
        newItem.setSummary("Biology encompasses the study of all living things, from cells and molecules to organisms and ecosystems. Wheaton biology majors conduct and present research, guided by expert faculty members, in well-equipped facilities. A rooftop greenhouse filled with diverse plants and on-campus woodlands are living labs for students, especially those interested in ecology and botany. A biology major provides a solid foundation for medical, dental, optometry, or veterinary school, as well a range of master’s and Ph.D. programs. If you’re interested in the health professions, Wheaton’s pre-med advising program will keep you on the right track.");
        newItem.setSheetURL("https://wheatoncollege.edu/wp-content/uploads/2010/06/dyer_microscope-220x146.jpg");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2010/06/dyer_microscope-220x146.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Business and Management");
        newItem.setCategory("Business and Management");
        newItem.setSummary("A business major that’s anything but business as usual. That’s what you’ll find in Wheaton’s multifaceted business and management program. With real-world consulting projects, immersive learning experiences, and a curriculum that covers more than the business side of business, you’ll leave Wheaton ready for the challenges of today’s marketplace. With five concentration options, you can focus on analytics, social responsibility, the environment, globalization, or nonprofits and the arts. This flexibility opens you up to a host of career opportunities from Wall Street to main street to applying business practices to community or creative organizations.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1754");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/blackboard-saved-300x231.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Chemistry");
        newItem.setCategory("Chemistry");
        newItem.setSummary("Chemistry matters. It’s involved in nearly everything we do in every aspect of our lives: cooking, cleaning, clothing, cures, you name it. Majoring in chemistry opens you up to exciting careers in research and development, regulation and quality control, public health, environmental protection, education, forensics, manufacturing and business. Chemistry also is a major of choice for many students interested in pursuing a career in medicine. As a chemistry major at Wheaton, you’ll explore and experiment in small, close-knit classes and labs and have chances to collaborate with your professors on research projects.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1755");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2011/01/Ali-Hussain-220x220.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Classics");
        newItem.setCategory("Classics");
        newItem.setSummary("Our curiosity about ancient civilizations has endured through the centuries, and their contributions to the world are evident even in modern society. Wheaton offers several classics majors: classical civilization, Greek, Latin, or Greek/Latin combined, all of which will cultivate your research, writing, and critical thinking skills. As a minor or second major, studying the classics can bring a whole new level to your main area of study. It complements English, history, art, anthropology, philosophy, and religion especially well, and it’s also an excellent foundation for law school or graduate programs.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2010/07/18058103_10155227833998328_2643588779026881277_n-220x149.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Computer Science");
        newItem.setCategory("Computer Science");
        newItem.setSummary("Computer science-related positions are a mainstay on annual “top careers” lists—and for good reason. Technology is part of everything we do. Devices and networks. Apps and algorithms. Ecommerce and online learning. At Wheaton, you’ll learn computing theory and then see it in action in classes like cryptography, data structures, and robots, games and problem solving. You can take your analytical and programming skills to nearly any industry, and into information security, database management, software development, IT, and related areas. Adding a minor or second major can make you even more marketable in emerging fields like genomics and data science.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1754");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/RS179866_computer-science-featured-300x259.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Creative Writing");
        newItem.setCategory("English");
        newItem.setSummary("We all have stories to tell and we can share them in many ways: poems, plays, short stories, novels, and essays to name a few—and we can share them on the page, online, or from the stage. A degree in creative writing could be the first chapter in your publishing career or the foreword to earning your MFA. Wheaton offers a vibrant, collaborative setting for aspiring writers. The literary arts are alive here, with two annual play festivals and the student-run lit mag, Rushlight. Our Visiting Artist Program brings accomplished authors to campus for readings, workshops, and master classes.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1755");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/12/10433113_309275075931228_5635481172698600491_n-220x164.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Dance");
        newItem.setCategory("Theatre and Dance Studies");
        newItem.setSummary("Dance is more than choreographed movements: It’s a challenging, freeing discipline that builds strength, focus, and confidence. And it’s an art that explores identity and enhances global and social awareness. A minor in dance combines technique with tradition: You’ll practice creative movement in jazz, ballet, and world music classes, while also discovering a historical and cultural perspective of dance. You’ll have opportunities to perform on the main stage with the Wheaton Dance Company or other theater and dance productions.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2015/11/artsandculturallearning296247-220x181.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Development Studies");
        newItem.setCategory("Development Studies");
        newItem.setSummary("Broaden your cultural understanding and enrich your Wheaton education with a minor in developmental studies. This broad field looks at the evolution of societies through multiple lenses: economical, sociological, and political. Your core course explores the political economy in developing countries in Asia, Africa, and Latin America. Then, you’ll choose from a variety of anthropology, economics, history, political science, and women and gender studies electives: sweatshops in the world economy, transnational feminism, urban anthropology, and the ecology and politics of food, just to name a few.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1754");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/Khadim-300x225.jpg");
        output.add(newItem);



        newItem = new Major();
        newItem.setTitle("Digital Humanities");
        newItem.setCategory("Digital Humanities");
        newItem.setSummary("Documentaries about history’s biggest mysteries. Multimedia museum exhibits. Interactive educational materials. Just think what you could create when you merge fascinating topics with technology. Digital humanities is a vast and versatile field—and an academic minor with major possibility. This interdisciplinary program can be combined with many areas of study, from art and anthropology to creative writing and computer science. The digital humanities minor gives you the flexibility to match courses with your skills and interests. Choose from options like Computing for Poets, Exhibition Design, and Digital Controversies.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/09/Digital-Humanities-300x292.png");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Early Childhood Education");
        newItem.setCategory("Education");
        newItem.setSummary("Pre-school, pre-K, and kindergarten teachers have an incredibly rewarding opportunity: to instill a love of learning and prepare children for a lifetime of discovery. As an early childhood education major, you’ll learn about child development and literacy, explore play and teaching strategies, and gain real-world experience observing, assisting, and teaching in diverse classrooms. With this degree and required certifications, you can provide care or teach in settings such as preschools, public and private elementary schools, community childcare programs, and social service organizations. Wheaton early childhood education students also choose a second major, broadening your career possibilities in education and beyond.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1754");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/12-W-570_Preschool-IMG_7211-300x200.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Economics");
        newItem.setCategory("Economics");
        newItem.setSummary("You’ll find economics at the intersection of business and social science. It’s about understanding how current events and conditions shape individuals and impact society—and how to use data to find and tell those stories. Choose electives or add a minor for a deeper dive into national and global issues that matter to you, such as health, gender, race, banking, politics, and international trade. A background in economics—and the analytical, research, and writing skills you’ll develop while studying it—can lead to many career paths including data science, journalism, finance, marketing, product development, and public policy.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1755");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/stock-1863880-econ-featured-300x225.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Economics");
        newItem.setCategory("Economics");
        newItem.setSummary("You’ll find economics at the intersection of business and social science. It’s about understanding how current events and conditions shape individuals and impact society—and how to use data to find and tell those stories. Choose electives or add a minor for a deeper dive into national and global issues that matter to you, such as health, gender, race, banking, politics, and international trade. A background in economics—and the analytical, research, and writing skills you’ll develop while studying it—can lead to many career paths including data science, journalism, finance, marketing, product development, and public policy.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1755");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/stock-1863880-econ-featured-300x225.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Elementary Education (Grade 1)");
        newItem.setCategory("Elementary Education");
        newItem.setSummary("Seeds are planted in elementary school. Students develop interests, discover talents, or have the first inkling of what they can be when they grow up. Along with intellectual growth, the early grades are pivotal for social and emotional development—and you will explore each of these angles at Wheaton through coursework and field work. Your lesson plan? Learn to teach math, science, reading, and language arts, while gaining knowledge of child development, education standards, and social issues relevant to today’s diverse classrooms. This program leads to elementary teacher licensure in Massachusetts, and a required second major broadens your career possibilities.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/child-865116_1280-elem-edu-featured-300x200.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Elementary Education (Grade 2)");
        newItem.setCategory("Elementary Education");
        newItem.setSummary("Seeds are planted in elementary school. Students develop interests, discover talents, or have the first inkling of what they can be when they grow up. Along with intellectual growth, the early grades are pivotal for social and emotional development—and you will explore each of these angles at Wheaton through coursework and field work. Your lesson plan? Learn to teach math, science, reading, and language arts, while gaining knowledge of child development, education standards, and social issues relevant to today’s diverse classrooms. This program leads to elementary teacher licensure in Massachusetts, and a required second major broadens your career possibilities.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/child-865116_1280-elem-edu-featured-300x200.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Elementary Education (Grade 3)");
        newItem.setCategory("Elementary Education");
        newItem.setSummary("Seeds are planted in elementary school. Students develop interests, discover talents, or have the first inkling of what they can be when they grow up. Along with intellectual growth, the early grades are pivotal for social and emotional development—and you will explore each of these angles at Wheaton through coursework and field work. Your lesson plan? Learn to teach math, science, reading, and language arts, while gaining knowledge of child development, education standards, and social issues relevant to today’s diverse classrooms. This program leads to elementary teacher licensure in Massachusetts, and a required second major broadens your career possibilities.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/child-865116_1280-elem-edu-featured-300x200.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Elementary Education (Grade 4)");
        newItem.setCategory("Elementary Education");
        newItem.setSummary("Seeds are planted in elementary school. Students develop interests, discover talents, or have the first inkling of what they can be when they grow up. Along with intellectual growth, the early grades are pivotal for social and emotional development—and you will explore each of these angles at Wheaton through coursework and field work. Your lesson plan? Learn to teach math, science, reading, and language arts, while gaining knowledge of child development, education standards, and social issues relevant to today’s diverse classrooms. This program leads to elementary teacher licensure in Massachusetts, and a required second major broadens your career possibilities.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/child-865116_1280-elem-edu-featured-300x200.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Elementary Education (Grade 5)");
        newItem.setCategory("Elementary Education");
        newItem.setSummary("Seeds are planted in elementary school. Students develop interests, discover talents, or have the first inkling of what they can be when they grow up. Along with intellectual growth, the early grades are pivotal for social and emotional development—and you will explore each of these angles at Wheaton through coursework and field work. Your lesson plan? Learn to teach math, science, reading, and language arts, while gaining knowledge of child development, education standards, and social issues relevant to today’s diverse classrooms. This program leads to elementary teacher licensure in Massachusetts, and a required second major broadens your career possibilities.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/child-865116_1280-elem-edu-featured-300x200.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Elementary Education (Grade 6)");
        newItem.setCategory("Elementary Education");
        newItem.setSummary("Seeds are planted in elementary school. Students develop interests, discover talents, or have the first inkling of what they can be when they grow up. Along with intellectual growth, the early grades are pivotal for social and emotional development—and you will explore each of these angles at Wheaton through coursework and field work. Your lesson plan? Learn to teach math, science, reading, and language arts, while gaining knowledge of child development, education standards, and social issues relevant to today’s diverse classrooms. This program leads to elementary teacher licensure in Massachusetts, and a required second major broadens your career possibilities.");
        newItem.setSheetURL("https://wheatoncollege.edu/academics/majors-minors/biology/#");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/child-865116_1280-elem-edu-featured-300x200.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("English");
        newItem.setCategory("English");
        newItem.setSummary("Studying literature—the classics to this week’s bestseller list— expands your understanding of humanity. As you turn each page, you’ll explore the elements of craft behind compelling poetry, fiction, nonfiction, drama, and film. Wheaton’s literature concentrations span geography, time, and topics: diversity, pop culture/media, medieval/renaissance, and colonialism/postcolonialism/global. With a keen eye for detail and equipped with myriad marketable skills, English majors fill writer, editor, content creator, project manager, analyst, research, and related roles in nearly every industry from publishing and marketing to law and healthcare. They’re also well-prepared for law school or graduate study.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1958");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/Bev-and-Student-300x294.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Environmental Studies");
        newItem.setCategory("Biology");
        newItem.setSummary("You can take your passion for the planet to a variety of fields: business, communications, healthcare, government, law, travel and tourism, and many more. If your future career goals are driven by the future of the world around (and under!) us, an environmental studies minor is an ideal companion to your major area of study. You’ll explore the environment through multiple perspectives, from learning about plants and organisms living in our wetlands and waterways to how human evolution, social movements, and globalization affect where and how we live.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1923");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/env_studies2-1-300x225.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Film and New Media Studies");
        newItem.setCategory("Film and New Media Studies");
        newItem.setSummary("With the ubiquity of online journalism, surge in streaming services, explosion of audiobooks and podcasts, rising readership of comics and graphic novels, and growth of branded content, it’s an exciting time to major in film and media. Explore cinematic history, examine media ethics, or challenge yourself with an unfamiliar genre or new behind-the-scenes skill. You’ll write, shoot, and edit short films, bring computer games to life, and learn how to engage an audience. The collaborative, project-based nature of our program means bonds with your peers and professors are part of your Wheaton storyline");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1925");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/video-2562034_640-300x169.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("French Studies");
        newItem.setCategory("French Studies");
        newItem.setSummary("France is known for its strong literary, artistic, and philosophical influences—and its food and fashion. Studying the French-speaking world—its language, its cultures, its histories—is not only intellectually fulfilling, but it also builds cultural competence. Wheaton’s French Studies majors study and write about cultural artifacts: film, literature, music. Beyond developing global awareness, learning to read, research, or write in a second language enriches graduate school and careers in business, education, law, medicine, politics, communications, and other fields");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1926");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/StValentinDevantEiffelSarapas-768x1024-225x300.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("German");
        newItem.setCategory("German");
        newItem.setSummary("German is the widest-used language in the European Union; you’ll hear it in Austria, Belgium, Liechtenstein, Luxembourg, and Switzerland. As you study this modern language in Wheaton’s close-knit community, you’ll explore German literature, pop culture, current events, and politics. Spend a semester or year abroad to practice your conversational German and experience everyday life in another culture. Majoring in German language and literature prepares you for careers in education, business,, foreign service, and translation. Our graduates have also served in the Peace Corps, taught abroad as Fulbright scholars, and earned advanced degrees in law, medicine, MBA, linguistics, theology, public policy.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1932");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/ruecke-300x201.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Greek");
        newItem.setCategory("Classics");
        newItem.setSummary("Language. Philosophy. Math. Mythology. So much of what we know today—our shared experiences and common knowledge—is rooted in ancient Greece. Wheaton’s classics department is devoted to antiquities and the enduring influence of early civilizations. As a Greek major, you’ll examine ancient texts and explore history, literature, and philosophy. Many students combine Greek with another humanities or social sciences major. With a well-rounded educated and sharpened analytical, research, and writing skills, our graduates are ready to pursue advanced degrees in philosophy, world languages, divinity, and law—or for a wide variety of careers.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1967");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/greek-drama2jpg-300x179.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Hispanic Studies");
        newItem.setCategory("Hispanic and Italian Studies");
        newItem.setSummary("More than 50 million people in the United States—and 400 million in the world—speak Spanish. Latin America is home to some of the nation’s largest trading partners. Traditions of Spanish-speaking countries have influenced people around the world. Wheaton’s Hispanic studies major will take you places—literally. Explore literature, traditions, and current affairs of countries in the Spanish-speaking world. Experience a different way of life and practice your conversational skills with a semester abroad. Your cultural understanding and ability to speak, read, and write in Spanish will give you an edge as you begin your career, no matter what profession you choose.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1937");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2011/12/300px-Philip_IV_of_Spain-copia-220x261.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("History");
        newItem.setCategory("History");
        newItem.setSummary("Understanding the past gives us context for today and helps us prepare for the future. Wheaton history majors preserve the past through internships with museums, libraries, and historical societies. They pursue independent research on an era, event, or figure that interests them. They study abroad to experience cultural history in person. Through all this, history majors build research, writing, critical thinking, and analytic skills, important assets to nearly any career. Many Wheaton history majors add a second area of study to expand their knowledge and career opportunities. Our alumni become teachers, professors, archivists, activists, librarians, and lawyers.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1941");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/RS153535_history-program-featured-300x300.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("History of Art");
        newItem.setCategory("Visual Art and History of Art");
        newItem.setSummary("For millennia, the artist’s imagination has captured stories, preserved cultures, and even stirred up mystery. When you consider time period and place, you gain a deeper understanding of what’s been created, who created it, and why. That’s what you’ll explore as a history of art major at Wheaton. Boost your visual literacy through object-based learning, visit galleries, interact with guest artists, and study with an expert faculty. Art history majors pursue fields like education, architecture, museums, and art restoration. Add an area of inquiry, such as social change or African diaspora, to further your knowledge or support graduate school ambitions.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1751");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2015/11/AMOMA_103123101941-220x315.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("International Relations");
        newItem.setCategory("Political Science");
        newItem.setSummary("The world is a big place, but it’s also smaller than we think. A major in international relations raises awareness and appreciation of the transnational and international links among countries, economies, and populations. As an international relations major at Wheaton, you’ll develop competency in a modern language and embark in real-world learning through internships, service work, or study abroad. These rich experiences coupled with coursework in political science, economics, history, and anthropology lead to exciting careers in diplomacy, foreign service, advocacy, and multinational business.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1946");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/IR-Program-card-300x164.png");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Italian Studies");
        newItem.setCategory("Hispanic and Italian Studies");
        newItem.setSummary("Interested in business, art or communication? Italy has the 8th largest economy in the world and the 3rd largest economy in Europe. Italy also has the most UNESCO World Heritage Sites of any country. Cultural competence and linguistic proficiency in Italian are professional assets for anyone planning to work in finance, fashion and design, the food and wine industries, tourism, and more. Our Italian Studies program offers students a variety of language, culture, film, and literature courses on Italy’s rich cultural history and language, with special emphasis on contemporary Italy. Italian Studies courses also equip students for advanced study and research.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1953");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/italy-516005_640-300x200.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Jewish Studies");
        newItem.setCategory("History");
        newItem.setSummary("The diverse world of Jewish studies makes for an enriching addition to your major course of study at Wheaton. Through classes that span disciplines, you’ll learn the history and culture of Jews around the world. Our students’ research projects are a good reflection of the broad scope of this field, with topics including Judaism and sustainable food movements; dramatic and visual artistic representations of the Holocaust; Jews, the Bible, and comics; and Judaism, gender, and sexuality.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1954");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/jerusalem-1120372_640-300x200.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Mathematics");
        newItem.setCategory("Mathematics");
        newItem.setSummary("In a world that runs on algorithms and information, mathematics has never been more marketable. US News & World Report ranked mathematician second on its Best Jobs of 2020 list. A degree in math can lead to in-demand careers in finance, data science, health information, market research, and business analysis. Many math majors share their passion for problem solving as high school teachers. Wheaton’s close-knit mathematics program offers you the flexibility to explore other academic interests through a second major or minor. Our graduates also pursue advanced and professional degrees in a variety of disciplines, including medicine and law.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1944");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/board-3804006_1280-math-featured-300x269.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Mathematics and Economics");
        newItem.setCategory("Economics");
        newItem.setSummary("Math + economics = plentiful career opportunities. Statistician and mathematician have ranked at the top of many recent “top jobs” lists. This interdisciplinary major strengthens your math skills, provides a foundation in U.S. and global economics, and builds analytical, organization, and communications abilities. This invaluable combination prepares you to ask the right questions, find the appropriate answers, and effectively present data to stakeholders so they can make informed decisions. Our graduates find careers in data science, finance, market research, bioinformatics, business analysis, or education; and they’re accepted into related master’s and Ph.D. programs.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1943");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/math-3986758_1920-math-econ-featured-300x217.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Music");
        newItem.setCategory("Music");
        newItem.setSummary("Performance and practice opportunities abound at Wheaton. Our vibrant music community is home to a distinguished faculty of scholar-performers, a visiting artist’s program, a world-class concert series, and a group of talented, energetic students. We offer a flexible music major with options to minor in performance, theory and composition, American music, ethnomusicology, and music history. Many of our students pursue graduate school, and others work in music business or arts management, perform professionally, or put their musician mentality to use in a range of other careers.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1903");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/woodwinds-1024x671-300x197.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Neuroscience");
        newItem.setCategory("Psychology");
        newItem.setSummary("Memory. Movement. Moods. Our brain and nervous system is responsible for how we think, feel, sense, and perceive—and there’s so much to still discover. That’s why neuroscience is such a fascinating area of study. It entails human biology: the molecules, cells, and genes that allow us to function. And it’s also psychology: learning, cognition, and behavior. Neuroscience also considers neurological and psychiatric conditions and altered states of consciousness. Wheaton’s interdisciplinary neuroscience major offers excellent preparation for post-graduate education.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1902");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2015/12/DAgostino-Robyn-220x164.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Philosophy");
        newItem.setCategory("Philosophy");
        newItem.setSummary("Philosophy is at the core of a liberal arts education. Asking big questions and exploring possibilities builds reasoning and analytical thinking skills ever-important to ethical leadership. Wheaton’s philosophy program is flexible; you can choose classes that match your curiosity, from the nature of morality to metaphysics. Adding philosophy as a minor or second major can broaden your way of thinking about your primary subject. And this versatile major also prepares you for graduate study in a range of disciplines, as well as for law or medical school.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1898");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2016/09/RS164201_Secondary-Poses_097-220x330.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Physics");
        newItem.setCategory("Physics and Astronomy");
        newItem.setSummary("Big universe. Small classes. As a physics major at Wheaton, you’ll learn about and experiment with subjects like optics, quantum mechanics, electromagnetic fields, astronomy, and planetary science. You will also embark on original scientific research, which could lead to co-authoring a paper with your professor or presenting your findings at a national conference. A physics major also aligns with our 3+2 dual degree option, which leads to a bachelor of arts from Wheaton and a bachelor’s in engineering from a partner program.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1895");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/Physics2_2191-300x200.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Political Science");
        newItem.setCategory("Political Science");
        newItem.setSummary("Civic-minded. Socially aware. Action-oriented. That’s how you might describe our political science majors. With aspirations to work in local, state, or federal government, in foreign service, or for a social impact organization, students in the political science program learn how to read carefully, think critically, communicate clearly, and develop sound arguments. Political science majors choose from a wide variety of classes covering everything from violence and revolution to pop culture and politics. Wheaton students learn by doing through community engagement, internships, field trips, and studying in political centers in the U.S. and abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1892");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/capital-hill-2645396_poli-sci-featured-300x225.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Psychology");
        newItem.setCategory("Psychology");
        newItem.setSummary("Human behavior. Thought and emotion. Majoring in psychology can lead to careers in human resources, health and human services, market research, sales, and a variety of helping professions—and even emerging fields like neuromarketing and performance psychology. Psychology majors with an interest in counseling, research, or health professions often pursue graduate school. As a psychology major at Wheaton, you’ll spend time in both classrooms and research labs exploring topics like developmental psychology, cognition, personality, animal behavior, neuroscience, and clinical psychology.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1889");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/capital-hill-2645396_poli-sci-featured-300x225.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Public Health (Anthropology)");
        newItem.setCategory("Public Health");
        newItem.setSummary("Vaccination and pasteurization. Seatbelt and texting laws. Nutritional labels and product warnings. Public health initiatives save lives, extend lives, and improve lives. Our individual safety and wellbeing depends upon the health of our communities. Public health officials study populations and how issues like chronic disease, addiction, and pollution impact global health. They’re also critical partners during pandemics, natural disasters, and other health crises. Wheaton’s public health major—with concentrations in anthropology, sociology and psychology—prepares you for careers in policy, regulation, communication, research, and health promotion. This major is also excellent preparation for advanced study in the social sciences, medicine or law.");
        newItem.setSheetURL("Public Health Major, Anthropology");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/microbiologist-1332376_640-300x202.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Public Health (Psychology)");
        newItem.setCategory("Public Health");
        newItem.setSummary("Vaccination and pasteurization. Seatbelt and texting laws. Nutritional labels and product warnings. Public health initiatives save lives, extend lives, and improve lives. Our individual safety and wellbeing depends upon the health of our communities. Public health officials study populations and how issues like chronic disease, addiction, and pollution impact global health. They’re also critical partners during pandemics, natural disasters, and other health crises. Wheaton’s public health major—with concentrations in anthropology, sociology and psychology—prepares you for careers in policy, regulation, communication, research, and health promotion. This major is also excellent preparation for advanced study in the social sciences, medicine or law.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1960");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/microbiologist-1332376_640-300x202.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Public Health (Sociology)");
        newItem.setCategory("Public Health");
        newItem.setSummary("Vaccination and pasteurization. Seatbelt and texting laws. Nutritional labels and product warnings. Public health initiatives save lives, extend lives, and improve lives. Our individual safety and wellbeing depends upon the health of our communities. Public health officials study populations and how issues like chronic disease, addiction, and pollution impact global health. They’re also critical partners during pandemics, natural disasters, and other health crises. Wheaton’s public health major—with concentrations in anthropology, sociology and psychology—prepares you for careers in policy, regulation, communication, research, and health promotion. This major is also excellent preparation for advanced study in the social sciences, medicine or law.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1961");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/microbiologist-1332376_640-300x202.jpg");
        output.add(newItem);



        newItem = new Major();
        newItem.setTitle("Religion");
        newItem.setCategory("Religion");
        newItem.setSummary("Exploring the many religions of the world—their texts and traditions—challenges our viewpoints, builds cultural awareness, and promotes empathy and understanding. In Wheaton’s religion program, you’ll compare and look critically at a range of belief systems and practices: Western Biblical traditions; Islam, East Asian, and native traditions; and contemporary movements like eco-feminism. Outside the classroom, our students observe “religion-in-action” through service learning, internships, study abroad, and other hands-on experiences. Open to students of all faiths or no faith, religion is an excellent major or minor for anyone who wants to broaden their worldview.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1878");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/abbey-1160492_640-300x186.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Russian Language and Literature");
        newItem.setCategory("Russian and Russian Studies department");
        newItem.setSummary("Russian literature is full of memorable stories and characters, and reading these works in their original language will give you a whole new perspective. Learning Russian, as with any new language, challenges how you write, speak, and think about English. One of the six official languages of the United Nations, Russian is a beneficial second language for international relations. In addition to advanced language courses, you will study creative works from films to sci-fi novels. Many of our students experience Russian culture firsthand by spending a semester abroad in Moscow, St. Petersburg, or perhaps in another Russian-speaking country.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1874");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2010/07/Kizhi-wooden-plaque-DSCF0487-220x334.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Russian Studies");
        newItem.setCategory("Russian and Russian Studies");
        newItem.setSummary("Russia, the largest country in the world, naturally offers much to explore, from arts and architecture to the economy and environment. The Russian studies major at Wheaton gives you a chance to explore this nation’s history and culture without an advanced language requirement. Our active and adventurous students engage campus in many ways, including Russian Table, a shared meal and conversation, and the colorful folk costume project. Many of our majors experience the culture firsthand by spending a semester in Russia or a Russian-speaking country.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1876");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2010/07/Matryoshki-3-IMG_3428-220x116.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Secondary Education (Biology Grades 8-12)");
        newItem.setCategory("Education");
        newItem.setSummary("There’s nothing like seeing someone have an aha! moment. If you have a passion for a particular subject matter and love sharing your knowledge about it, teaching middle or high school could be an ideal career path. When you study secondary education at Wheaton, you’ll fulfill licensure requirements to teach high school in Massachusetts, while gaining expertise in the content area of your choice. Secondary ed students can major in biology, chemistry, English, French, history, mathematics, or Spanish. Your student-teaching and fieldwork experiences will take you to diverse classrooms across the region, and even abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1905");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/apple-256261_640-300x198.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Secondary Education (Chemistry Grades 8-12)");
        newItem.setCategory("Education");
        newItem.setSummary("There’s nothing like seeing someone have an aha! moment. If you have a passion for a particular subject matter and love sharing your knowledge about it, teaching middle or high school could be an ideal career path. When you study secondary education at Wheaton, you’ll fulfill licensure requirements to teach high school in Massachusetts, while gaining expertise in the content area of your choice. Secondary ed students can major in biology, chemistry, English, French, history, mathematics, or Spanish. Your student-teaching and fieldwork experiences will take you to diverse classrooms across the region, and even abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1906");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/apple-256261_640-300x198.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Secondary Education (English Grades 5-12)");
        newItem.setCategory("Education");
        newItem.setSummary("There’s nothing like seeing someone have an aha! moment. If you have a passion for a particular subject matter and love sharing your knowledge about it, teaching middle or high school could be an ideal career path. When you study secondary education at Wheaton, you’ll fulfill licensure requirements to teach high school in Massachusetts, while gaining expertise in the content area of your choice. Secondary ed students can major in biology, chemistry, English, French, history, mathematics, or Spanish. Your student-teaching and fieldwork experiences will take you to diverse classrooms across the region, and even abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1907");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/apple-256261_640-300x198.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Secondary Education (French Grades 8-12)");
        newItem.setCategory("Education");
        newItem.setSummary("There’s nothing like seeing someone have an aha! moment. If you have a passion for a particular subject matter and love sharing your knowledge about it, teaching middle or high school could be an ideal career path. When you study secondary education at Wheaton, you’ll fulfill licensure requirements to teach high school in Massachusetts, while gaining expertise in the content area of your choice. Secondary ed students can major in biology, chemistry, English, French, history, mathematics, or Spanish. Your student-teaching and fieldwork experiences will take you to diverse classrooms across the region, and even abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1908");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/apple-256261_640-300x198.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Secondary Education (History Grades 8-12)");
        newItem.setCategory("Education");
        newItem.setSummary("There’s nothing like seeing someone have an aha! moment. If you have a passion for a particular subject matter and love sharing your knowledge about it, teaching middle or high school could be an ideal career path. When you study secondary education at Wheaton, you’ll fulfill licensure requirements to teach high school in Massachusetts, while gaining expertise in the content area of your choice. Secondary ed students can major in biology, chemistry, English, French, history, mathematics, or Spanish. Your student-teaching and fieldwork experiences will take you to diverse classrooms across the region, and even abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1909");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/apple-256261_640-300x198.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Secondary Education (Mathematics Grades 8-12)");
        newItem.setCategory("Education");
        newItem.setSummary("There’s nothing like seeing someone have an aha! moment. If you have a passion for a particular subject matter and love sharing your knowledge about it, teaching middle or high school could be an ideal career path. When you study secondary education at Wheaton, you’ll fulfill licensure requirements to teach high school in Massachusetts, while gaining expertise in the content area of your choice. Secondary ed students can major in biology, chemistry, English, French, history, mathematics, or Spanish. Your student-teaching and fieldwork experiences will take you to diverse classrooms across the region, and even abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=19010");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/apple-256261_640-300x198.jpg");
        output.add(newItem);

        newItem = new Major();
        newItem.setTitle("Secondary Education (Spanish Grades 8-12)");
        newItem.setCategory("Education");
        newItem.setSummary("There’s nothing like seeing someone have an aha! moment. If you have a passion for a particular subject matter and love sharing your knowledge about it, teaching middle or high school could be an ideal career path. When you study secondary education at Wheaton, you’ll fulfill licensure requirements to teach high school in Massachusetts, while gaining expertise in the content area of your choice. Secondary ed students can major in biology, chemistry, English, French, history, mathematics, or Spanish. Your student-teaching and fieldwork experiences will take you to diverse classrooms across the region, and even abroad.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1905");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2014/04/apple-256261_640-300x198.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Sociology");
        newItem.setCategory("Sociology");
        newItem.setSummary("Sociology is an incredibly diverse field of study. At its core is human interaction, which can be studied from many perspectives: education, environment, the workplace, and other social structures. A major in sociology introduces you to research methods, hones your writing skills, builds emotional intelligence, and increases your cultural competency. After graduation, Wheaton sociology majors often pursue advanced degrees in the social sciences. This major also prepares you for careers in health and human services, marketing, law enforcement, public policy, and urban planning.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1872");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/pedestrians-918471_640-300x200.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Theatre and Dance Studies (Acting/Directing and Design/Tech)");
        newItem.setCategory("Theatre and Dance Studies");
        newItem.setSummary("Write a script. Audition for a role. Build a set. Choreograph a scene. Being part of a show—from a short play in a black box theatre to a major musical production on the main stage—is fun, fulfilling, and memorable. The grueling work, collaborative efforts, time management, and technical skill involved is also excellent preparation for any career. Wheaton’s theatre and dance studies majors study acting, directing, theatre design and history, dance, dramatic literature, playwriting, and film theory. With a vibrant arts scene on campus, you’ll find many opportunities for on-stage or behind-the-scenes roles.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1868");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/theatre-dance-collage-f2012-2-flat-257x300.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Theatre and Dance Studies (Dance)");
        newItem.setCategory("Theatre and Dance Studies");
        newItem.setSummary("Write a script. Audition for a role. Build a set. Choreograph a scene. Being part of a show—from a short play in a black box theatre to a major musical production on the main stage—is fun, fulfilling, and memorable. The grueling work, collaborative efforts, time management, and technical skill involved is also excellent preparation for any career. Wheaton’s theatre and dance studies majors study acting, directing, theatre design and history, dance, dramatic literature, playwriting, and film theory. With a vibrant arts scene on campus, you’ll find many opportunities for on-stage or behind-the-scenes roles.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1866");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/08/theatre-dance-collage-f2012-2-flat-257x300.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Visual Art");
        newItem.setCategory("Visual Art and History of Art");
        newItem.setSummary("Originality. Problem solving. Deep thinking. Discipline. The habits and skills you develop in the visual arts can be applied to many career paths. Wheaton’s visual art major will provide you expert instruction, sunny studios, state-of-the-art spaces, and the right tools and equipment—and you’ll bring the inspiration and creativity. See what comes to life as you learn techniques in design, drawing, filmmaking, painting, photography, printmaking, and sculpture. Art blends well with many disciplines, making this an excellent minor or second major.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1869");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2010/08/art-student-alum-collage-400px-220x232.jpg");
        output.add(newItem);


        newItem = new Major();
        newItem.setTitle("Women’s and Gender Studies");
        newItem.setCategory("Women’s and Gender Studies");
        newItem.setSummary("Gender shapes who we are, as individuals and as social institutions. Majoring in women’s and gender studies means exploring the intersections of gender, race, class, and sexuality—present day and throughout history. Your classes will span the disciplines: history, biology, sociology, psychology, art, modern languages, and more. Take deep dives into topics like masculinity in modern art, sexuality in film noir, feminist fiction, families in transition, queer theory, or women in the U.S. economy. Our majors and minors are motivated to create positive change; you’ll find them using class projects, research, and internships to advocate, educate, fundraise, and volunteer.");
        newItem.setSheetURL("https://catalog.wheatoncollege.edu/preview_program.php?catoid=8&poid=1863");
        newItem.setPreviewImageURL("https://wheatoncollege.edu/wp-content/uploads/2017/07/feminism-is-for-everybody-2.jpg");
        output.add(newItem);

        return output;
    }


}
