INSERT INTO SUCCESS_STORIES VALUES (1, 'Fever') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STORIES VALUES (2, 'Sugar') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STORIES VALUES (3, 'Skin Problem') ON CONFLICT DO NOTHING;

INSERT INTO PERSON VALUES (1, 'Selva','Madurai') ON CONFLICT DO NOTHING;
INSERT INTO PERSON VALUES (2, 'Vineeth','Theni') ON CONFLICT DO NOTHING;
INSERT INTO PERSON VALUES (3, 'Nagarajan','Covai') ON CONFLICT DO NOTHING;


INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (1, 'document','http://','Yes') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (2, 'pdf','http://','No') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (3, 'video','http://','Yes') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (4, 'audio','http://','Yes') ON CONFLICT DO NOTHING;

INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (5, 'document','http://', 'Yes') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (6, 'pdf','http://','No') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (7, 'video','http://','Yes') ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STRY_DATA_FRMT VALUES (8, 'audio','http://','Yes') ON CONFLICT DO NOTHING;



#Success story and Person relation many to many relation many story many person
INSERT INTO SUCCESS_STORIES_PERSON VALUES (1, 1) ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STORIES_PERSON VALUES (1, 2) ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STORIES_PERSON VALUES (1, 3) ON CONFLICT DO NOTHING;

INSERT INTO SUCCESS_STORIES_PERSON VALUES (2, 1) ON CONFLICT DO NOTHING;
INSERT INTO SUCCESS_STORIES_PERSON VALUES (2, 2) ON CONFLICT DO NOTHING;
 
#Person and Available format relation
INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (1, 1) ON CONFLICT DO NOTHING;
INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (1, 2) ON CONFLICT DO NOTHING;
INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (1, 3) ON CONFLICT DO NOTHING;
INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (1, 4) ON CONFLICT DO NOTHING;

INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (2, 5) ON CONFLICT DO NOTHING;
INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (2, 6) ON CONFLICT DO NOTHING;
INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (2, 7) ON CONFLICT DO NOTHING;
INSERT INTO PERSON_AVAILABLE_FORMAT VALUES (2, 8) ON CONFLICT DO NOTHING;


#Delete records if need

delete from SUCCESS_STRY_DATA_FRMT
delete from SUCCESS_STORIES_PERSON