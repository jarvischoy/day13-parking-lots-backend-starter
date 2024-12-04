implement the Parking Manager for me: As a Parking Manager, I am responsible for managing three parking lots: ● The Plaza Park (9 parking capacity) ● City Mall Garage (12 parking capacity) ● Office Tower Parking (9 parking capacity) I have employed three Parking Boys to help manage these parking lots, each utilizing a specific parking strategy:
Standard parking strategy
Smart parking strategy
Super Smart parking strategy


implement the following apis: get: /parkinglot, return all parking lots post: /parkinglot/park, park the car in request body to the parking lots available base on the strategy selected in request body post: /parkinglot/fetch, fetch the car in request body from the parking lots



convert the parkrequest and fetch request to dto


modify the apis and dtos so that /park request body only contains a license number and strategy.