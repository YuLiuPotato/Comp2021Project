package hk.edu.polyu.comp.comp2021.g17.cvfs.model.filesystem;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.FileAlreadyExistException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.FileNotExistException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.InvalidArgumentException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.InvalidFileNameException;
import hk.edu.polyu.comp.comp2021.g17.cvfs.model.exception.UsageException;

class FileSystemTest {
	
	FileSystem fileSystem;
	
	FileSystemTest(){
		fileSystem = new FileSystem("test");
	}

	@Test
	void loadStoreTest() {
		try {
			String pathLoad = "C:\\toLoad"; //directory on your disk
			String pathStore = "C:\\toStore"; //directory on your disk
			fileSystem.newDisk("100000");
			fileSystem.load(pathLoad);
			fileSystem.rList("");
			fileSystem.store(pathStore);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
