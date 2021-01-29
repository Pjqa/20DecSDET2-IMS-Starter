Coverage: 44%
# IMS

A functional java application, that can be ran throught a command line

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software 

```
Git
MYSQL
Java
Apache Maven
Eclipse
Sonarqube
```

### Installing

```
Download Git from here https://git-scm.com/download/win
Create a repository on Github
Copie the URL of the repository you want to clone
Open a Git bash terminal where ever you want to work
Finally type in - git clone https://github.com/Pjqa/Class.git (URL you want to clone)
```
## Running the tests
Find your Maven Package you want to test using your command line then
```
mvm test
```

### Unit Tests 
Is where each individual component of the code are tested. The purpose is to validate that each of componets of the code performs as expected.


```
@Test
    public void testReadAll() {
        List<Item> expected = new ArrayList<>();
        expected.add(new Item(1L, "Lolly", 0.55));
        expected.add(new Item(2L, "Haribos", 1.55));
        assertEquals(expected, DAO.readAll());
    }
```

### Coding style tests

Shows if your coding style matches up industry meanins the readability, and maintainability of the code 
and the complexity of it. Sonarqube was going to be used to do this 

### Deloyment 
Need SQL database inorder to run the project 
```
CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
	`iid` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(40) NOT NULL,
	`price` DOUBLE NOT NULL,
	PRIMARY KEY (`iid`)
);

CREATE TABLE IF NOT EXISTS `orders` (
    `oid` INT(11) NOT NULL AUTO_INCREMENT,
    `fk_id` INT NOT NULL,
    `price` DOUBLE,
    PRIMARY KEY (`oid`),
    FOREIGN KEY (`fk_id`) REFERENCES `customers` (`id`) ON DELETE CASCADE
);    
    
CREATE TABLE IF NOT EXISTS `orderlines` (
    `rid`  INT(11) NOT NULL AUTO_INCREMENT,
    `fk_iid` INT NOT NULL,
    `fk_oid` INT NOT NULL,
    PRIMARY KEY (`rid`),
    FOREIGN KEY (`fk_iid`) REFERENCES `items` (`iid`) ON DELETE CASCADE , 
    FOREIGN KEY (`fk_oid`) REFERENCES `orders` (`oid`) ON DELETE CASCADE
);
```


## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* ** Peprah Amoh-Donkor** -*Finished*-[Pjqa](https://github.com/Pjqa)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Nick
* Pawel
* Team Serpent
