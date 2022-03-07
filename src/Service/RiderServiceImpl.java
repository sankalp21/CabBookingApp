package src.Service;

import java.util.Optional;

import src.Model.Location;
import src.Model.Rider;
import src.Repository.IRepository;
import src.Repository.RepositoryImpl;
import src.Storage.Storage;

public class RiderServiceImpl implements IRiderService{
	private IRepository<String, Rider> riderRepository;
	
	public RiderServiceImpl(Storage<String, Rider> riderStorage) {
		this.riderRepository = new RepositoryImpl<String, Rider>(riderStorage);
	}
	
	@Override
	public Rider addRider(Rider rider) {
		// TODO Auto-generated method stub
		Optional<Rider> riderOpt = riderRepository.save(rider);
		return riderOpt.get();
	}

	@Override
	public Rider updateRider(String riderName, Rider rider) {
		// TODO Auto-generated method stub
		Optional<Rider> riderOpt = riderRepository.update(rider);
		return riderOpt.get();
	}

	@Override
	public void updateRiderLocation(String riderName, Location location) throws Exception {
		// TODO Auto-generated method stub
		Optional<Rider> riderOpt = riderRepository.findById(riderName);
		
		if(!riderOpt.isPresent()) {
			throw new RuntimeException("User with username : "+ riderName + " doesn't exists");
		}
		
		Rider rider = riderOpt.get();
		rider.setLocation(location);
		riderRepository.save(rider);
	}

}
