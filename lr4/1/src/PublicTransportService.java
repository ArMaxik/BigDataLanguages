public class PublicTransportService {
    public class Route {
        public class RouteTime {
            String dispatchTime;
            String arriveTime;

            RouteTime(String dispatchTime, String arriveTime) {
                this.dispatchTime = dispatchTime;
                this.arriveTime = arriveTime;
            }
        }

        RouteTime[] schedule;
        int fare;

        Route(RouteTime[] schedule, int fare) {
            this.schedule = schedule;
            this.fare = fare;
        }
    }

    Route[] routes;
    
    PublicTransportService(Route[] routes) {
        this.routes = routes;
    }
}
