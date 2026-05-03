ParkingLot is always a Singleton instance managing one parking lot.
Factory pattern - VehicleFactory or SpotFactory to decouple logic creation.
Strategy - FeeStrategy - HourlyFeesStrategy or DailyFeesStrategy can be implemented. Preferred by Interviewers.

How it works:
1. ParkingLot.setupParkingLot. This can be synchronized call.
2. Vehicle arrives -> addVehicle(Vehicle)
3. Generate a ticket (Entry time, vehicle, Parking spot)
4. On exit, Payment object is created and fee is computed via FeeStrategy.

Followup questions:
How do you handle concurrency?
Synchronized blocks or ReentrantLock on spot assignment, or optimistic locking.
How do you support multiple entry/exit gates?
EntryGate and ExitGate classes that interact with ParkingLot.
How do you handle handicapped spots?
Add HandicappedSpot subclass and a flag/enum on the spot.
What if the lot is full?
parkVehicle() throws ParkingLotFullException or returns null/Optional.

