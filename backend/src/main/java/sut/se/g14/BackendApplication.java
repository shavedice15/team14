package sut.se.g14;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CharacterEncodingFilter;
import sut.se.g14.entity.*;
import sut.se.g14.repository.*;

import java.sql.Time;
import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	String[] typeOfTypeMusic = {
			"POP",
			"ROCK",
			"HIPHOP",
			"JAZZ",
			"R&B",
			"CLASSIC",
			"Country"
	};

	String [] nameOfBand = {
			"IKON",
			"WINNER",
			"BLACKPING"
	};
	String [] nameProducer = {
			"Manderin",
			"Harry",
			"Mozart"
	};
	@Bean
	CharacterEncodingFilter characterEncodingFilter() {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		return filter;
	}

	@Bean
	ApplicationRunner init(ArtistRepository artistRepository,
						   ContactRepository contactRepository,
						   GenderRepository genderRepository,
						   ManagerRepository managerRepository,
						   TypeContactRepository typeContactRepository,
						   CountryRepository countryRepository,
						   ArtistsRepository artistsRepository,
						   BandRepository bandRepository,
						   TypeMusicRepository typeMusicRepository,
						   DressRepository dressRepository,
						   EventRepository eventRepository,
						   SizeRepository sizeRepository,
						   TypeRepository typeRepository,
						   MembersRepository membersRepository,
						   PlaceRepository placeRepository,
						   QuereRepository quereRepository,
						   TypeWorkRepository typeWorkRepository,
						   StatusRepository statusRepository ,TypeContractRepository typeContractRepository,
						   StatusdressRepository statusdressRepository,
						   HireMoneyRepository hireMoneyRepository,
						   AlbumsRepository albumsRepository,
						   ProducerRepository producerRepository,
						   SongRepository songRepository,
						   PracticeRepository practiceRepository,
						   TypePracticeRepository typePracticeRepository,
						   RoomPracticeRepository roomPracticeRepository,
						   TypeRoomPracticeRepository typeRoomPracticeRepository,
						   TypePrivilegeRepository typePrivilegeRepository,
						   DateExpMonthRepository dateExpMonthRepository,
						   DateExpYearRepository dateExpYearRepository,
						   ProfileRepository profileRepository,
						   IDCardRepository idCardRepository) {
		return args -> {
			//Manager
			Stream.of("Male", "Female").forEach(gender -> {
				Gender newGender = new Gender();
				newGender.setGender(gender);
				genderRepository.save(newGender);
			});

			

			Stream.of("Tel.", "Email", "Facebook", "Twitter", "Instagram", "Line").forEach(type -> {
				TypeContact newType = new TypeContact();
				newType.setType(type);
				typeContactRepository.save(newType);
			});

			Stream.of("mimi").forEach(username -> {
				Gender gender = genderRepository.findById(2L);
				Manager newManager = new Manager();
				newManager.setName("mini mimi");
				newManager.setGender(gender);
				newManager.setUsername(username);
				newManager.setPassword("12345678");
				managerRepository.save(newManager);

				Contact newContact = new Contact();
				Manager manager = managerRepository.findByUsername(username);
				TypeContact type = typeContactRepository.findById(4L);

				newContact.setContact("@mimini");
				newContact.setType(type);
				contactRepository.save(newContact);
				manager.getContactSet().add(newContact);
				managerRepository.save(manager);
			});

			artistRepository.findAll().forEach(System.out::println);
			genderRepository.findAll().forEach(System.out::println);
			typeContactRepository.findAll().forEach(System.out::println);
			contactRepository.findAll().forEach(System.out::println);
			managerRepository.findAll().forEach(System.out::println);

			//Artists

			Stream.of(nameOfBand).forEach(bandname -> {
				Band band = new Band();
				band.setBandname(bandname);
				bandRepository.save(band);
			});
			bandRepository.findAll().forEach(System.out::print);

			Stream.of(typeOfTypeMusic).forEach(typemusics -> {
				TypeMusic typeMusic = new TypeMusic();
				typeMusic.setTypemusics(typemusics);
				typeMusicRepository.save(typeMusic);
			});
			typeMusicRepository.findAll().forEach(System.out::print);



			//Register , Privilege VIP
			Stream.of("2019", "2020", "2021", "2022",
					"2023", "2024", "2025", "2026",
					"2027", "2028", "2029", "2030",
					"2031", "2032", "2033", "2034" ).forEach(expYear ->{
				DateExpYear newDateExpYear = new DateExpYear();
				newDateExpYear.setExpYear(expYear);
				dateExpYearRepository.save(newDateExpYear);
			});

			Stream.of("01", "02", "03", "04", "05", "06",
					"07", "08", "09", "10", "11", "12").forEach(expMonth ->{
				DateExpMonth newDateExpMonth = new DateExpMonth();
				newDateExpMonth.setExpMonth(expMonth);
				dateExpMonthRepository.save(newDateExpMonth);
			});

			Stream.of("Backstage Concert",
					"Dance Practice",
					"Special Concert").forEach(typePrivilege ->{
				TypePrivilege newTypePrivilege = new TypePrivilege();
				newTypePrivilege.setTypePrivilege(typePrivilege);
				typePrivilegeRepository.save(newTypePrivilege);
			});

			Stream.of(
					"Albania", "Algeria",
					"Arab Emirates", "Argentina",
					"Australia", "Austria",
					"Bahrain", "Bangladesh",
					"Belarus", "Belgium",
					"Brazil", "Brunei Darussalam",
					"Bulgaria", "Botswana",
					"Cambodia", "Canada",
					"Cape Verde", "Chile",
					"China", "CostaRica",
					"Croatia", "Cyprus",
					"Czech Republic", "Denmark",
					"Djibouti", "Dominican Republic",
					"Ecuador", "Egypt",
					"Estonia", "Ethiopia",
					"Fiji", "Finland",
					"France", "Germany",
					"Greece", "Hong Kong",
					"Hungary", "India",
					"Indonesia", "Iran",
					"Ireland", "Israel",
					"Japan", "Jordan",
					"Kazakhstan", "Kenya",
					"Latvia", "Lesotho",
					"Luxembourg", "Macau",
					"Macedonia", "Malaysia",
					"Mauritius", "Mexico",
					"Mongolia", "Morocco",
					"Mozambique", "Myanma",
					"Netherlands", "Netherlands Antilles",
					"New Zealand", "Nigeria",
					"Norway", "Oman",
					"Panama", "Peru",
					"Philippines", "Poland",
					"Portugal", "Qatar",
					"Romania", "Russian Federation",
					"Rwanda", "Saudi Arabia",
					"Singapore", "Slovakia",
					"Slovenia", "South Korea",
					"Spain", "Sri Lanka",
					"Sweden", "Switzerland",
					"Thailand", "Tunisia",
					"Turkey", "Ukraine",
					"United Kingdom", "United States",
					"Uzbekistan", "Vietnam",
					"Zambia").forEach(countryName -> {
				Country newCountry = new Country();
				newCountry.setCountryName(countryName);
				countryRepository.save(newCountry);
			});

			


			//Dress
			sizeRepository.save(new Sizes("S"));
			sizeRepository.save(new Sizes("M"));
			sizeRepository.save(new Sizes("L"));
			sizeRepository.save(new Sizes("XL"));
			sizeRepository.save(new Sizes("XXL"));
			sizeRepository.findAll().forEach(System.out::println);


			typeRepository.save(new Type("ชุดราตรี"));
			typeRepository.save(new Type("ชุดเดินแบบ"));
			typeRepository.save(new Type("ชุดโฆษณา"));
			typeRepository.save(new Type("ชุดEvent"));
			typeRepository.findAll().forEach(System.out::println);


			eventRepository.save(new Event("โฆษณา"));
			eventRepository.save(new Event("ละคร"));
			eventRepository.save(new Event("คอนเสิร์ต"));
			eventRepository.save(new Event("Event"));
			eventRepository.findAll().forEach(System.out::println);

			statusdressRepository .save(new Statusdress("Receive"));
			statusdressRepository.save(new Statusdress("Repatriate"));
			statusdressRepository.findAll().forEach(System.out::println);
			//Queue
			Stream.of("งานแต่งงาน", "งานปาร์ตี้", "งานบวช", "งานมหาวิทยาลัย", "งานเลี้ยง", "โรงแรม", "ร้านอาหาร", "อีเว้นท์ทั่วไป", "งาน Event Grand Openning",
					"งาน Event Pop-up Marget", "งาน Event Venue/Mall", "อื่นๆ").forEach(type -> {
				TypeWork typeWork = new TypeWork();
				typeWork.setTypeWork(type);
				typeWorkRepository.save(typeWork);
			});

			Stream.of("wait", "success", "cancle").forEach(status -> {
				Status statusquere = new Status();
				statusquere.setStatusQuere(status);
				statusRepository.save(statusquere);
			});

				//hiremoney
				Stream.of("100,000 Baht","50,000 baht","25,000 Baht").forEach(hire -> {
					HireMoneyEntity h = new HireMoneyEntity();
					h.setMoney(hire);
					hireMoneyRepository.save(h);
				});

				//typeContract
				Stream.of("ร้องเพลง & โมเดลลิ่ง","music").forEach(type -> {
					TypeContractEntity t = new TypeContractEntity();

					t.setTypeContract(type);
					typeContractRepository.save(t);
				});

			//Albums
			producerRepository.findAll().forEach(System.out::print);

			Song songs = new Song();
			songs.setName("Love Love");
			Time timeSongSet = new Time(Integer.parseInt("00"), Integer.parseInt("02"), Integer.parseInt("45"));
			songs.setTime(timeSongSet);
			songRepository.save(songs);
			songRepository.findAll().forEach(System.out::println);

			Song songs1 = new Song();
			songs1.setName("Du Du");
			Time timeSongSet1 = new Time(Integer.parseInt("00"), Integer.parseInt("03"), Integer.parseInt("00"));
			songs1.setTime(timeSongSet1);
			songRepository.save(songs1);
			songRepository.findAll().forEach(System.out::println);

			//Practice
			Stream.of("ซ้อมดนตรี", "ซ้อมการแสดง", "ซ้อมเต้น", "อื่นๆ").forEach(type -> {
				TypePractice typePractice = new TypePractice(type);
				typePracticeRepository.save(typePractice);
			});

			Stream.of("ห้องซ้อมดนตรี", "ห้องซ้อมทั่วไป").forEach(type -> {
				TypeRoomPractice typeRoomPractice = new TypeRoomPractice(type);
				typeRoomPracticeRepository.save(typeRoomPractice);
			});

			Stream.of("A00", "A01", "A02", "A03", "A04", "A05", "B00", "B01", "B02", "B03", "B04", "B05").forEach(room -> {
				if(room == "A00" || room == "A01" || room == "A02" || room == "A03" || room == "A04" || room == "A05" ) {
					TypeRoomPractice type = typeRoomPracticeRepository.findById(1L);
					RoomPractice roomPractice = new RoomPractice(room, type);
					roomPracticeRepository.save(roomPractice);
				}
				else if(room == "B00" || room == "B01" || room == "B02" || room == "B03" || room == "B04" || room == "B05"  ) {
					TypeRoomPractice type = typeRoomPracticeRepository.findById(2L);
					RoomPractice roomPractice = new RoomPractice(room, type);
					roomPracticeRepository.save(roomPractice);
				}

			});
		};

		
		
		
	}

}

