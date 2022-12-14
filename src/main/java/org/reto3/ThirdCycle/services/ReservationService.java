package org.reto3.ThirdCycle.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import org.reto3.ThirdCycle.entities.Client;
import org.reto3.ThirdCycle.entities.ReportClient;
import org.reto3.ThirdCycle.entities.Reservation;
import org.reto3.ThirdCycle.repositories.ClientRepository;
import org.reto3.ThirdCycle.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    //Attributes
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private ClientRepository clientRepository;

    //Constructor
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    // CRUD Methods

        //Report generation
            public List<ReportClient> getReservationsReportClients(){
                List<ReportClient> listReportClients = new ArrayList();
                List<Client> listClients = this.clientRepository.findAll();
                for(int i=0; i<listClients.size(); i++){
                    ReportClient reportClient = new ReportClient(listClients.get(i));
                    listReportClients.add(reportClient);
                }
                return listReportClients;
            }

            public List<Reservation> getReservationsReportDates(String start, String end){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd", Locale.ENGLISH);
                formatter.setTimeZone(TimeZone.getTimeZone("America/New_York"));

                Date startDate = new Date();
                Date endDate = new Date();
                try {
                    startDate = formatter.parse(start);
                    endDate = formatter.parse(end);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return this.reservationRepository.findByStartDateBetween(startDate, endDate);
            }

        // END Report generation


    public List<Reservation> getAllReservations() {
        return this.reservationRepository.findAll();
    }

    public Reservation getReservationById(int id) {
        if (!this.reservationRepository.findById(id).isEmpty()) {
            return this.reservationRepository.findById(id).get();
        } else {
            return null;
        }
    }

    public Reservation createReservation(Reservation reservation) {
        return this.reservationRepository.save(reservation);
    }

    public void deleteReservation(int id) {
        if (this.reservationRepository.findById(id).isPresent()) {
            this.reservationRepository.deleteById(id);
        }
    }

    public void updateReservation(int id, Reservation reservation) {
        if (this.reservationRepository.findById(id).isPresent()) {
            Reservation reservationDB = this.reservationRepository.findById(id).get();

            this.reservationRepository.save(reservationDB);
        }
    }
}
